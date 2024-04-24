package com.jemgroup.unicab.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authManager;

    public void authenticateUser(String username, String password){
        // generate token
        UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(username, password);
        try {
            authManager.authenticate(authReq);
        } catch (Exception e){
            e.printStackTrace();
        }
        log.info("User is Authenticated");
//        SecurityContext sc = SecurityContextHolder.getContext();
//        sc.setAuthentication(auth);
    }


}
