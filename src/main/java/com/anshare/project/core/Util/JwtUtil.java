package com.anshare.project.core.Util;

import com.anshare.project.model.system.Auth;
import org.springframework.security.core.context.SecurityContextHolder;

public class JwtUtil {
    //拿到jwt中暂存的信息
    public static Auth GetAuths(){
        Auth auth = (Auth) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return auth;
    }

}
