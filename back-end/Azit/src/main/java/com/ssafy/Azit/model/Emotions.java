package com.ssafy.Azit.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Emotions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emotionsId;

    private Double surprise;
    private Double joy;
    private Double sadness;
    private Double anger;
    private Double fear;
    private Double disgust;
    private Double contempt;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

//    @NotNull
//    @ManyToOne
//    @JoinColumn(name = "")
//    private String userId;
}
