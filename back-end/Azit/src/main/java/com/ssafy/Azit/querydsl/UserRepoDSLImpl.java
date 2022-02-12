package com.ssafy.Azit.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.Azit.model.QUser;
import com.ssafy.Azit.model.User;
import com.ssafy.Azit.res.UserRes;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UserRepoDSLImpl implements UserRepoDSL {

    private final JPAQueryFactory jpaQueryFactory;

    QUser qUser = QUser.user;

    @Override
    public Optional<User> findByUserId(String userId) {

        User user = jpaQueryFactory.select(qUser).from(qUser).where(qUser.userId.eq(userId)).fetchOne();

        if(user == null) return Optional.empty();
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> login(User user) {

        User loginUser = jpaQueryFactory.selectFrom(qUser)
                .where(qUser.userId.eq(user.getUserId()), qUser.password.eq(user.getPassword())).fetchOne();


        if(loginUser == null) return Optional.empty();
        return Optional.ofNullable(loginUser);
    }


}
