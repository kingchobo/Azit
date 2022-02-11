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
//        System.out.println(userId);
//        System.out.println(userRepository.findById(userId));
        User user = userService.getUserByUserId(userId);

        return ResponseEntity.ok().body(user);
    }
    @PostMapping()
    public ResponseEntity<String> createUser(@RequestBody User user){
//        System.out.println(user);

//        System.out.println("-------------------------");
//        System.out.println("sdf" +  userRepository.save(user) + "sdf");
//        System.out.println("-------------------------");

        User createdUser = userService.createUser(user);

        if(!ObjectUtils.isEmpty(createdUser))
            return ResponseEntity.ok().body(SUCCESS);
        return ResponseEntity.ok().body(FAIL);

    }
}
