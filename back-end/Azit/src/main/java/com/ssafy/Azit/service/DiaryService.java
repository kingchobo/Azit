package com.ssafy.Azit.service;

import com.ssafy.Azit.model.Diary;
import com.ssafy.Azit.model.User;

import java.util.List;

public interface DiaryService {

    Diary createDiary(Diary diary);
    Diary getDiary(long diaryId);

    List<Diary> listDiary(String userId);
    List<Diary> listSearchDiary(String word);

    Diary updateDiary(Diary diary);
    Diary deleteDiary(long diaryId);

}
