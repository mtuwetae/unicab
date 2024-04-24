//package com.jemgroup.unicab.config;
//
//
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebFilter;
//
//import java.io.IOException;
//
//@WebFilter("/*")
//public class MyFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//
//        System.out.println("Request is being processed by MyFilter");
//
//
//        filterChain.doFilter(servletRequest, servletResponse);
//
//
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//
//}
