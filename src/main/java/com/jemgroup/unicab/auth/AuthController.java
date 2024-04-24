package com.jemgroup.unicab.auth;

import com.jemgroup.unicab.dto.LoginDTO;
import com.jemgroup.unicab.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {

    @Autowired
    private AuthenticationService authService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginDTO loginDTO){
        try {
            authService.authenticateUser(loginDTO.getUsername(), loginDTO.getPassword());

            // get user

            // genarate token
            final String token = jwtTokenUtil.generateToken(loginDTO.getUsername());
                log.info(token);
            // return token
//            String token

            return ResponseEntity.ok(token);
        } catch (AuthenticationException e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
