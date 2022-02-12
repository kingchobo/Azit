package com.ssafy.Azit.service;

import com.ssafy.Azit.model.Diary;
import com.ssafy.Azit.model.User;
import com.ssafy.Azit.repository.DiaryRepository;
import com.ssafy.Azit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import java.util.List;

@Service
public class DiaryServiceImpl implements DiaryService {

    @Autowired
    private DiaryRepository diaryRepository;

    @Override
    public Diary createDiary(Diary diary) {

//        String userId = diary.getUser();

        return diaryRepository.save(diary);
    }


    @Override
    public Diary getDiary(long diaryId) {
        return diaryRepository.findByDiaryId(diaryId).get();
    }

    @Override
    public Diary updateDiary(Diary diary) {
        return null;
    }

    @Override
    public Diary deleteDiary(long diaryId) {
        return null;
    }

    @Override
    public List<Diary> listDiary() {
        return null;
    }

    @Override
    public List<Diary> listSearchDiary(String word) {
        return null;
    }
}
