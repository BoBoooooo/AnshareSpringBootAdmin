package com.anshare.project.controller;
import com.alibaba.fastjson.JSONObject;
import com.anshare.project.core.RedisService;
import com.anshare.project.model.Role;
import com.anshare.project.service.RoleService;
import io.jsonwebtoken.Claims;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.anshare.project.configurer.ConstantKey;
import com.anshare.project.core.Result;
import com.anshare.project.core.ResultGenerator;
import com.anshare.project.model.Users;
import com.anshare.project.service.UsersService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Example;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin

@RestController
@Api(value = "登录管理", description = "登录管理")
@RequestMapping("/login")
public class LoginController  {
    @Resource
    private UsersService usersService;
    @Resource
    private RoleService roleService;
    @Resource
    private RedisService redisService;
       @ApiOperation(value = "登录接口")
    @PostMapping(value = "/login")
    public Result login(String username, String password, HttpServletResponse response) {

        Condition condition = new Condition(Users.class);
        condition.createCriteria()
                .andEqualTo("username",username)
                .andEqualTo("password",password);

        List<Users> userVo = usersService.findByCondition(condition);
        if (userVo!=null&&userVo.size()>0) {
            Users user = userVo.get(0);


            Role role =roleService.findById(user.getRoleid());

            if(role!=null){
                String subject = user.getUsername() + "-"
                        +user.getRealname()+ "-"
                        + role.getRoleauthname();
                long time = System.currentTimeMillis();
                String token = Jwts.builder()
                        .setSubject(subject)
                        .setExpiration(new Date( time+  24 * 60 * 60 * 1000)) // 设置过期时间 1 * 24 * 60 * 60秒情况修改)
                        .signWith(SignatureAlgorithm.HS512, ConstantKey.SIGNING_KEY) //采用什么算法是可以自己选择的，不一定非要采用HS512
                        .compact();
                // 登录成功后，返回token到header里面


                redisService.setStr(user.getUsername(),token);

                return ResultGenerator.genSuccessResult(token);

            }

            else
            {

                return ResultGenerator.genFailResult("该用户未绑定角色");

            }

        }
        else{

            return ResultGenerator.genFailResult("用户名或密码错误");

        }
    }


    @ApiOperation(value = "获取用户身份信息")
    @PostMapping(value = "/userinfo")
    public Result UserInfo(HttpServletRequest request, HttpServletResponse response) {

        String Auth = request.getHeader("auth");

        if(Auth!=null&&Auth!=""){

                String subject =  parseJWT(Auth);

                String rolelist = subject.split("-")[2];

            String UserName = subject.split("-")[0];
            String RealName = subject.split("-")[1];

            JSONObject json = new JSONObject();
            json.put("Roles",rolelist);
            json.put("RealName",RealName);
            json.put("UserName",UserName);


            return ResultGenerator.genSuccessResult(json);

        }

        else{

            return ResultGenerator.genFailResult("获取用户信息失败");

        }
    }


    private String parseJWT(String jwt) {
//This line will throw an exception if it is not a signed JWS (as expected)
        Claims claims = Jwts.parser()
                .setSigningKey(ConstantKey.SIGNING_KEY)
                .parseClaimsJws(jwt).getBody();
        System.out.println("ID: " + claims.getId());
        System.out.println("Subject: " + claims.getSubject());
        System.out.println("Issuer: " + claims.getIssuer());
        System.out.println("Expiration: " + claims.getExpiration());

        return claims.getSubject();
    }



}
