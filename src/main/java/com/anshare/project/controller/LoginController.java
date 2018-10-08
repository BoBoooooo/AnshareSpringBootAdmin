package com.anshare.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.anshare.project.configurer.JwtConfig;
import com.anshare.project.core.RedisService;
import com.anshare.project.core.ResultCore.Result;
import com.anshare.project.core.ResultCore.ResultGenerator;
import com.anshare.project.core.Util.JwtUtil;
import com.anshare.project.model.Role;
import com.anshare.project.model.Users;
import com.anshare.project.service.MenuService;
import com.anshare.project.service.RoleService;
import com.anshare.project.service.UsersService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@CrossOrigin

@RestController
@Api(value = "登录管理", description = "登录管理")
@RequestMapping("/login")
public class LoginController {
    @Resource
    private UsersService usersService;
    @Resource
    private RoleService roleService;
    @Resource
    private RedisService redisService;
    @Resource
    private MenuService menuService;

    @ApiOperation(value = "登录接口")
    @PostMapping(value = "/login")
    public Result login(String username, String password, HttpServletResponse response) {

        Condition condition = new Condition(Users.class);
        condition.createCriteria()
                .andEqualTo("username", username)
                .andEqualTo("password", password);

        List<Users> userVo = usersService.findByCondition(condition);



        if (userVo != null && userVo.size() > 0) {
            Users user = userVo.get(0);


            Role role = roleService.findById(user.getRoleid());

            if (role != null) {
                String subject = user.getUsername() + ","
                        + user.getRealname() + ","
                        + user.getRoleid()+","
                       + user.getDeptid();
                long time = System.currentTimeMillis();
                String token = Jwts.builder()
                        .setSubject(subject)
                        .setExpiration(new Date(time + JwtConfig.Time)) // 设置过期时间 1 * 24 * 60 * 60秒情况修改)
                        .signWith(SignatureAlgorithm.HS512, JwtConfig.SIGNING_KEY) //采用什么算法是可以自己选择的，不一定非要采用HS512
                        .compact();
                // 登录成功后，返回token到header里面
                redisService.setStr(user.getUsername(), token);
                return ResultGenerator.genSuccessResult(token,"登录成功");

            } else {

                return ResultGenerator.genFailResult("该用户未绑定角色");

            }

        } else {

            return ResultGenerator.genFailResult("用户名或密码错误");

        }
    }


    @ApiOperation(value = "获取用户身份信息以及对应的菜单信息")
    @PostMapping(value = "/userinfo")
    public Result UserInfo(HttpServletRequest request, HttpServletResponse response) {

        String Auth = request.getHeader("auth");

        if (Auth != null && Auth != "") {

            String[] subject = JwtUtil.GetDetails();


            String UserName = subject[0];
            String RealName = subject[1];
            String RoleID = subject[2];
            String DeptID = subject[3];

            JSONObject json = new JSONObject();
            json.put("RealName", RealName);
            json.put("UserName", UserName);
            json.put("Routers",menuService.GetMenuTreeByRoleID(RoleID) );

            return ResultGenerator.genSuccessResult(json);

        } else {

            return ResultGenerator.genFailResult("获取用户信息失败");

        }
    }

    @ApiOperation(value = "修改密码")
    @PostMapping(value = "/changepassword")
    public Result changepassword(HttpServletRequest request,String password) {

        String[] subject = JwtUtil.GetDetails();
        String UserName = subject[0];

        Condition condition = new Condition(Users.class);
        condition.createCriteria()
                .andEqualTo("username", UserName);
        List<Users> userVo = usersService.findByCondition(condition);
        if (userVo != null && userVo.size() > 0) {
            Users user = userVo.get(0);
            user.setPassword(password);
            usersService.update(user);
            redisService.del(UserName);

        }

        return ResultGenerator.genAuthTokenErrResult("");


    }




    @ApiOperation(value = "登出")
    @PostMapping(value = "/logout")
    public Result logout(HttpServletRequest request,HttpServletResponse response) {
        String subject = JwtUtil.parseJWT(request);
        String UserName = subject.split(",")[0];

        redisService.del(UserName);

        return ResultGenerator.genAuthTokenErrResult("");


    }

    @ApiOperation(value = "redis Key获取value")
    @PostMapping(value = "/getkey")
    public Result getvaluebykey(String key, HttpServletResponse response) {


        String value = redisService.getStr(key);

        return ResultGenerator.genSuccessResult(value);


    }



    @ApiOperation(value = "test 异常")
    @PostMapping(value = "/test")
    public Result getvaluebykey() {


        throw new SecurityException("测试");


    }


}
