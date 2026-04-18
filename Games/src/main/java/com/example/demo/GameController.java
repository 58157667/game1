package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api1")
public class GameController {

    @Autowired
    private UserRepository userRepo;

    // 注册
    @PostMapping("/register1")
    public User register(@RequestBody User user) {
        return userRepo.save(user);
    }

    // 登录
    @PostMapping("/login1")
    public User login(@RequestBody User user) {
        return userRepo.findByUsername(user.getUsername());
    }

   
}
