package com.jemgroup.unicab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/secured")
    public String secured(){
        return "Hello Secured";
    }
}
