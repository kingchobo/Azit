package com.ssafy.Azit.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GroupStatus {

    OPENED("OPENED", "열림"),
    CLOSED("CLOSED", "닫힘");


    private String code;
    private String value;
}
