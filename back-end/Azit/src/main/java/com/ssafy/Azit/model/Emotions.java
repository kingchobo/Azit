package com.ssafy.Azit.model;

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

    private Double neutral;
    private Double happy;
    private Double sad;
    private Double angry;
    private Double fearful;
    private Double disgusted;
    private Double surprised;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

//    @NotNull
//    @ManyToOne
//    @JoinColumn(name = "")
//    private String userId;
}
