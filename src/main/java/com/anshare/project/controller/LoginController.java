package com.anshare.project.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.anshare.project.configurer.JwtConfig;
import com.anshare.project.core.RedisService;
import com.anshare.project.core.ResultCore.Result;
import com.anshare.project.core.ResultCore.ResultGenerator;
import com.anshare.project.core.Util.JwtUtil;
import com.anshare.project.model.system.Auth;
import com.anshare.project.model.system.Dept;
import com.anshare.project.model.system.Role;
import com.anshare.project.model.system.Users;
import com.anshare.project.service.inter.system.DeptService;
import com.anshare.project.service.inter.system.RoleService;
import com.anshare.project.service.inter.system.UsersService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
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
    private DeptService deptService;
    @Resource
    private RoleService roleService;
    @Resource
    private RedisService redisService;

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
            Dept dept = deptService.findById(user.getDeptid());

            if (role != null) {
                com.anshare.project.model.system.Auth authObject = new com.anshare.project.model.system.Auth();
                authObject.setDeptID(user.getDeptid());
                authObject.setUserName(user.getUsername());
                authObject.setRealName(user.getRealname());
                authObject.setRoleID(user.getRoleid());
                authObject.setUserID(user.getId());
                authObject.setRoleName(role.getRolename());
                authObject.setDeptName(dept.getDeptname());

                String subject = JSON.toJSONString(authObject);

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
            Auth subject = JwtUtil.GetAuths();
            String UserName =subject.getUserName();
            String RealName =subject.getRealName();
            String RoleID =subject.getRoleID();
            String DeptID = subject.getDeptID();

            JSONObject json = new JSONObject();
            json.put("RealName", RealName);
            json.put("UserName", UserName);
//            json.put("Routers",menuService.GetMenuTreeByRoleID(RoleID) );
            json.put("RoleAuthName",roleService.findById(RoleID).getRoleauthname());
            return ResultGenerator.genSuccessResult(json);

        } else {

            return ResultGenerator.genFailResult("获取用户信息失败");

        }
    }

    @ApiOperation(value = "修改密码")
    @PostMapping(value = "/changepassword")
    public Result changepassword(HttpServletRequest request,String password) {

        Auth subject = JwtUtil.GetAuths();
        String UserName =subject.getUserName();

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
    public Result logout() {
        Auth auth = JwtUtil.GetAuths();
        String UserName = auth.getUserName();
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
    @GetMapping(value = "/test")
    public Result getvaluebykey(@RequestParam String token,@RequestParam String mobile,@RequestParam String message) {



        return ResultGenerator.genSuccessResult(token+";"+mobile+";"+message);

    }


}
