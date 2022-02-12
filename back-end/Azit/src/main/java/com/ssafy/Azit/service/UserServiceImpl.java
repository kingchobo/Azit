package com.ssafy.Azit.service;

import com.ssafy.Azit.model.User;
import com.ssafy.Azit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);

    }

    @Override
    public User getUserByUserId(String userId) {

        return userRepository.findByUserId(userId).orElse(null);
    }

    @Override
    public User login(User user) {
        return userRepository.login(user).orElse(null);
    }
}
