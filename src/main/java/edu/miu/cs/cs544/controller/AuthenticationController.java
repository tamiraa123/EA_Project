package edu.miu.cs.cs544.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @RequestMapping("/")
    public String login() {
        String auth = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
        return "LOGGED IN as "+ auth;
    }
}
