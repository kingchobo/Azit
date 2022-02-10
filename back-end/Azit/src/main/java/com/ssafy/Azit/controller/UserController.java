package com.ssafy.Azit.controller;

import com.ssafy.Azit.model.User;
import com.ssafy.Azit.repository.UserRepository;
import com.ssafy.Azit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
public class UserController {

    private final String SUCCESS = "success";
    private final String FAIL = "fail";

//    @Autowired
//    private UserRepository userRepository;
    @Autowired
    private UserService userService;

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

        if(!ObjectUtils.isEmpty(user))
            return ResponseEntity.ok().body(SUCCESS);
        return ResponseEntity.ok().body(FAIL);

    }
}
