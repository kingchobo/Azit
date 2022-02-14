package com.ssafy.Azit.service;

import com.ssafy.Azit.model.DiaryGroup;
import com.ssafy.Azit.repository.DiaryGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiaryGroupServiceImpl implements DiaryGroupService{

    @Autowired
    DiaryGroupRepository diaryGroupRepository;

    @Override
    public DiaryGroup createDiaryGroup(DiaryGroup diaryGroup) {
        return diaryGroupRepository.save(diaryGroup);
    }
}
