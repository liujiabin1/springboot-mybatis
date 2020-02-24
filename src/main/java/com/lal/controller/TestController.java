package com.lal.controller;

import com.lal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String testSpringBoot() {
        return "hello word";
    }

    @RequestMapping("/test")
    public String findUser() {
        return userService.findUser();
    }
}
