package com.belle.springsecurityjwt.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String index() {
        return "hello";
    }

    @GetMapping("/userpage")
    public String httpApi() {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "userpage";
    }

    @GetMapping("/adminpage")
    public String httpSuite() {
        return "userpage";
    }

}
