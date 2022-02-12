package com.ssafy.Azit.querydsl;

import com.ssafy.Azit.model.User;

import java.util.Optional;

public interface UserRepoDSL {

    public Optional<User> findByUserId(String userId);


}
