package com.anshare.project.core.Util;

import com.anshare.project.configurer.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;

public class JwtUtil {
    //拿到jwt中暂存的信息
    public static String[] GetDetails(){

        String[] auth = ((String[]) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
            return auth;
    }

    public static  String parseJWT(HttpServletRequest request) {
//This line will throw an exception if it is not a signed JWS (as expected)


        String jwt = request.getHeader("auth");

        Claims claims = Jwts.parser()
                .setSigningKey(JwtConfig.SIGNING_KEY)
                .parseClaimsJws(jwt).getBody();
        System.out.println("ID: " + claims.getId());
        System.out.println("Subject: " + claims.getSubject());
        System.out.println("Issuer: " + claims.getIssuer());
        System.out.println("Expiration: " + claims.getExpiration());

        return claims.getSubject();
    }

}
