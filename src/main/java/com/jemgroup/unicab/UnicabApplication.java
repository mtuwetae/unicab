package com.jemgroup.unicab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jemgroup"})
public class UnicabApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnicabApplication.class, args);
    }

}
