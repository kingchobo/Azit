package com.ssafy.Azit.controller;

import com.ssafy.Azit.model.DiaryGroup;
import com.ssafy.Azit.service.DiaryGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/diaryGroup")
public class DiaryGroupController {

    @Autowired
    DiaryGroupService diaryGroupService;

    @PostMapping
    public ResponseEntity<DiaryGroup> createDiaryGroup(@RequestBody DiaryGroup diaryGroup){

        DiaryGroup createdDiaryGroup = diaryGroupService.createDiaryGroup(diaryGroup);

        return ResponseEntity.ok().body(createdDiaryGroup);

    }



}
