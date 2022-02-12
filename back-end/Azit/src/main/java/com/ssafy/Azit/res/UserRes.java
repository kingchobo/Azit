package com.ssafy.Azit.res;

import com.ssafy.Azit.enums.Gender;
import com.ssafy.Azit.enums.GroupStatus;
import lombok.*;

import java.util.Date;

public interface UserRes {

    String getUserId();
    String getName();
    String getPhoneNum();
    Gender getGender();
    String getEmail();
    Date getBirthDate();
    String getNickname();
    Date getSignDate();
    GroupStatus getGroupStatus();
}
