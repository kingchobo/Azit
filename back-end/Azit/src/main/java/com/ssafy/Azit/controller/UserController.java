package com.ssafy.Azit.controller;

import com.ssafy.Azit.model.User;
import com.ssafy.Azit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{userId}")
    public Optional<User> findUser (@PathVariable String userId){
        System.out.println("Dasd");
        return userRepository.findById(userId);
    }
    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        System.out.println("oo");
        return userRepository.save(user);
    }
}
