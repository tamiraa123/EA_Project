package edu.miu.cs.cs544.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @RequestMapping("/")
    public String login() {
        return "LOGGED IN";
    }
}
