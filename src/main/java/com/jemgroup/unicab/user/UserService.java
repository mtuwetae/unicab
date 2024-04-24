package com.jemgroup.unicab.user;

import com.jemgroup.unicab.user.UserDTO;
import com.jemgroup.unicab.user.User;
import com.jemgroup.unicab.entity.UserRole;
import com.jemgroup.unicab.exception.UserRegistrationException;
import com.jemgroup.unicab.user.UserRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Getter
@Service
@Slf4j
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(UserDTO userDTO) {
        UserRole role = determineUserRole(userDTO);
        // Null checks
        if (userDTO == null) {
            throw new IllegalArgumentException("UserDTO cannot be null");
        }

        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new UserRegistrationException("Email already taken");
        }

        String generatedUsername = generateUniqueUserName(userDTO.getFirstName(), userDTO.getLastName());

        if (userRepository.existsByUserName(generatedUsername)) {
            throw new UserRegistrationException("Username already taken");
        }

        User newUser = new User();
        newUser.setUserName(userDTO.getUserName());
        newUser.setEmail(userDTO.getEmail());
        newUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        newUser.setTelephoneNumber(userDTO.getTelephoneNumber());
        newUser.setFirstName(userDTO.getFirstName());
        newUser.setLastName(userDTO.getLastName());
        newUser.setRole(role);

        log.info(newUser.toString());
        userRepository.save(newUser);

    }

//    private UserRole determineUserRole(UserDTO userDTO){
//        String role = userDTO.getRole();
//
//        if ("DRIVER".equalsIgnoreCase(role)) {
//            return UserRole.DRIVER;
//        } else if ("STUDENT".equalsIgnoreCase(role)) {
//            return UserRole.STUDENT;
//        } else {
//            throw new IllegalArgumentException("Invalid user role: " + role);
//        }
//    }

    private UserRole determineUserRole(UserDTO userDTO) {
        if ("driver".equalsIgnoreCase(userDTO.getRole())) {
            return UserRole.DRIVER;
        } else if ("admin".equalsIgnoreCase(userDTO.getRole())) {
            return UserRole.ADMIN;
        } else if ("student".equalsIgnoreCase(userDTO.getRole())) {
            return UserRole.STUDENT;
        } else {
            throw new IllegalArgumentException("Invalid user role: " + userDTO.getRole());
        }
    }

    private String generateUniqueUserName(String firstName, String lastName) {
        String baseUsername = (firstName + lastName).toLowerCase().replaceAll("\\s", "_");

        String generatedUsername = baseUsername;
        int count = 1;
        while (userRepository.existsByUserName(generatedUsername)) {
            generatedUsername = baseUsername + "_" + count;
            count++;
        }

        return firstName.toLowerCase() + "_" + lastName.toLowerCase() + "_" + UUID.randomUUID().toString().substring(0, 8);

    }

    public boolean authenticateUser(String email, String password) {
        User user = userRepository.findByEmail(email);

        return user != null && passwordEncoder.matches(password, user.getPassword());
    }
}