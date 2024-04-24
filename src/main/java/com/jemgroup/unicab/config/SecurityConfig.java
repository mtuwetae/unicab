package com.jemgroup.unicab.config;

import com.jemgroup.unicab.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.context.annotation.Configuration;
import com.jemgroup.unicab.config.JwtRequestFilter;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;



@Configuration
@EnableWebSecurity
@Component
public class SecurityConfig  {


    private UserDetailsServiceImpl userDetailsService;

    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    public SecurityConfig(UserDetailsServiceImpl userDetailsService, JwtRequestFilter jwtRequestFilter){
        this.userDetailsService = userDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public Filter jwtRequestFilter() {
//        return new JwtRequestFilter();
//    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
//    }

    @Bean
    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf((csrf) -> csrf.disable())
                .authorizeRequests()
                .requestMatchers("/api/auth/**","/api/user/**").permitAll()
//                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers("/api/**").hasAnyRole("DRIVER", "STUDENT" , "ADMIN")
                .anyRequest().authenticated().and()
//                .httpBasic(Customizer.withDefaults())
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

//    @Bean
//    public SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> securityConfigurerAdapter() {
//        return new SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {
//            @Override
//            public void configure(HttpSecurity http) throws Exception {
//                http.csrf().disable()
//                        .authorizeRequests()
//                        .antMatchers("/api/auth/**").permitAll()
//                        .antMatchers("/api/user/**").hasAnyRole("DRIVER", "STUDENT")
//                        .anyRequest().authenticated();
//                http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//            }
//        };
//    }

}