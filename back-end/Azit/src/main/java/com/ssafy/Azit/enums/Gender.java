package com.ssafy.Azit.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {

    MAN("M", "남성"),
    WOMAN("F", "여성");

    private String code;
    private String value;

}
