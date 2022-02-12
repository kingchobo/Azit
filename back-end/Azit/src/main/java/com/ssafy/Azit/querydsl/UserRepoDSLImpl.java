package com.ssafy.Azit.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.Azit.model.QUser;
import com.ssafy.Azit.model.User;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UserRepoDSLImpl implements UserRepoDSL {

    private final JPAQueryFactory jpaQueryFactory;

    QUser qUser = QUser.user;

    @Override
    public Optional<User> findByUserId(String userId) {

        System.out.println("-------------");
        System.out.println(userId);
        System.out.println(userId);
        System.out.println(userId);
        System.out.println(userId);
        System.out.println(userId);
        System.out.println(jpaQueryFactory);
        System.out.println("-------------");

        User user = jpaQueryFactory.selectFrom(qUser).where(qUser.userId.eq(userId)).fetchOne();


        System.out.println("동작");
        System.out.println("동작");
        System.out.println("동작");
        System.out.println("동작");
        System.out.println("동작");

        if(user == null) return Optional.empty();
        return Optional.ofNullable(user);
    }

}
