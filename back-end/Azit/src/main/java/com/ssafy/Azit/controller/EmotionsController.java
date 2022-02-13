package com.ssafy.Azit.controller;

import com.ssafy.Azit.model.Emotions;
import com.ssafy.Azit.service.EmotionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/emotions")
public class EmotionsController {

    @Autowired
    private EmotionsService emotionsService;

    @PostMapping
    public ResponseEntity<Emotions> createEmotions(@RequestBody Emotions emotions){

        Emotions createdEmotions = emotionsService.createEmotions(emotions);

        return ResponseEntity.ok().body(createdEmotions);

    }

    @GetMapping("/{emotionsId}")
    public ResponseEntity<Emotions> findEmotions(@PathVariable Long emotionsId){

        Emotions emotions = emotionsService.findEmotions(emotionsId);

        return ResponseEntity.ok().body(emotions);
    }


}
