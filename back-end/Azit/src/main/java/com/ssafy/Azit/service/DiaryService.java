package com.ssafy.Azit.service;

import com.ssafy.Azit.model.Diary;

import java.util.List;

public interface DiaryService {

    Diary createDiary(Diary diary);
    Diary getDiary(long diaryId);
    Diary updateDiary(Diary diary);
    Diary deleteDiary(long diaryId);
    List<Diary> listDiary();
    List<Diary> listSearchDiary(String word);

}
