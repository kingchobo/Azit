package com.ssafy.Azit.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GroupOpen {

    OPEN("T", "열림"),
    CLOSE("F", "닫힘");


    private String code;
    private String value;
}
