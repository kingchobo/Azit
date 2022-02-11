package com.ssafy.Azit.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {

    MALE("MALE", "남성"),
    FEMALE("FEMALE", "여성");

    private String code;
    private String value;

}
