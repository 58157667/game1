package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/register")
    public String register(@RequestBody User user) {

        if (userRepo.findByUsername(user.getUsername()) != null) {
            return "用户名已存在";
        }

        userRepo.save(user);
        return "注册成功";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User dbUser = userRepo.findByUsername(user.getUsername());

        if (dbUser == null || !dbUser.getPassword().equals(user.getPassword())) {
            return "登录失败";
        }

        return "登录成功";
    }
}