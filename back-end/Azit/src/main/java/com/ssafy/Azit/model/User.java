package com.ssafy.Azit.model;

import com.ssafy.Azit.enums.Gender;
import com.ssafy.Azit.enums.GroupOpen;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(length = 30)
    private String userId;

    @Column(length = 30)
    private String name;

    @Column(length = 15)
    private String phoneNum;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Gender gender;

    private String email;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    private String nickname;

    private String password;

    private Date signDate;

    @Enumerated(EnumType.STRING)
    private GroupOpen groupOpen;

}
