package com.ssafy.Azit.service;

import com.ssafy.Azit.model.Diary;
import com.ssafy.Azit.model.User;

import java.util.List;

public interface DiaryService {

    Diary createDiary(Diary diary);
//    Diary createDiary(Diary diary, User user);
    Diary getDiary(long diaryId);

    List<Diary> listDiary(String userId, int page);
    List<Diary> listSearchDiary(String userId, String title, int page);

    Diary updateDiary(Diary diary);
    int deleteDiary(long diaryId);

}
