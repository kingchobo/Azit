package com.ssafy.Azit.service;

import com.ssafy.Azit.model.Emotions;
import com.ssafy.Azit.repository.EmotionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmotionsServiceImpl implements EmotionsService{

    @Autowired
    private EmotionsRepository emotionsRepository;

    @Override
    public Emotions createEmotions(Emotions emotions) {
        return  emotionsRepository.save(emotions);
    }

    @Override
    public Emotions findEmotions(Long emotionsId) {
        return emotionsRepository.findByEmotionsId(emotionsId).orElse(null);
    }
}
