package com.mzk.springsecuritydemo.controller;

import com.mzk.springsecuritydemo.config.security.MyWebAuthenticationDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author miaozhenkai
 * @version 2021-07-12  15:36
 */
@RestController
public class HelloController {



    @GetMapping("/hello")
    public String hello() {
        //authentication
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        MyWebAuthenticationDetails details = (MyWebAuthenticationDetails) authentication.getDetails();

        System.out.println(details);
        System.out.println(authentication.getAuthorities());
        System.out.println(authentication.isAuthenticated());
        System.out.println(authentication.getCredentials());
        System.out.println(authentication.getPrincipal());
        return "hello";
    }

    @GetMapping("/admin/hello")
    public String admin() {
        return "admin";
    }

    @GetMapping("/user/hello")
    public String user() {
        return "user";
    }
}