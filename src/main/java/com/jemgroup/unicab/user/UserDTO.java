package com.jemgroup.unicab.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
public class UserDTO {
    private String userName;
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String email;
    private String password;
    private String role;

}
