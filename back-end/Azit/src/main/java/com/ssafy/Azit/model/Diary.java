package com.ssafy.Azit.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// Default = snake_case
//@Table(name = "diary")
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "diary_id")
    private Long diaryId;

    @Column(length = 30)
    private String title;

    private String videoLink; // Default length = 255

//    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String thumbNail;

//    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToOne
    @JoinColumn(name="emotions_id")
    private Emotions emotions;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private DiaryGroup diaryGroup;

    /* Foreign Keys */
//    @NotNull
//    @Column(length = 30)
//    private String userId;
//
//    private Long emotionsId;
//    private Long groupId;













}
