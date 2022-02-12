package com.ssafy.Azit.repository;

import com.ssafy.Azit.model.User;
import com.ssafy.Azit.querydsl.UserRepoDSL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String>, UserRepoDSL {

    Optional<User> findByUserId(String userId);

}
