package com.ssafy.Azit.service;


import com.ssafy.Azit.model.User;


public interface UserService {

    User createUser(User user);
    User getUserByUserId(String userId);
    User login(User user);


}
