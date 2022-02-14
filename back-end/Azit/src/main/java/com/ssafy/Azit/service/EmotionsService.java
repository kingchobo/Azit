package com.ssafy.Azit.service;

import com.ssafy.Azit.model.Emotions;

public interface EmotionsService {

    Emotions createEmotions(Emotions emotions);
    Emotions findEmotions(Long emotionsId);

}
