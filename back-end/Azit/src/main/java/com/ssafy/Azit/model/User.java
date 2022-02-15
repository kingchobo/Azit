package com.ssafy.Azit.model;

import com.ssafy.Azit.enums.Gender;
import com.ssafy.Azit.enums.GroupStatus;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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

//    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    private Date signDate;

    @Enumerated(EnumType.STRING)
    @NotNull
    private GroupStatus groupStatus;

}
