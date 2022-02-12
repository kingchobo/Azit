package com.ssafy.Azit.controller;

import com.ssafy.Azit.model.User;
import com.ssafy.Azit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    @GetMapping("/{userId}")
    public ResponseEntity<User> findUser (@PathVariable String userId){
        User user = userService.getUserByUserId(userId);

        return ResponseEntity.ok().body(user);
    }
    @PostMapping()
    public ResponseEntity<String> createUser(@RequestBody User user){

        User createdUser = userService.createUser(user);

        if(createdUser != null)
            return ResponseEntity.ok().body(SUCCESS);
        return ResponseEntity.ok().body(FAIL);

    }
}
