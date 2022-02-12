package com.ssafy.Azit.controller;

import com.ssafy.Azit.model.Diary;
import com.ssafy.Azit.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/diary")
public class DiaryController {

    @Autowired
    private DiaryService diaryService;

    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    // 일기 상세 정보 조회
    @GetMapping("/{diaryId}")
    public ResponseEntity<Diary> getDetailDiary (@PathVariable long diaryId) {
        Diary diary = diaryService.getDiary(diaryId);

        return ResponseEntity.ok().body(diary);
    }

    // 일기 작성
    @PostMapping()
    public ResponseEntity<String> createDiary(@RequestBody Diary diary) {
        Diary createdDiary = diaryService.createDiary(diary);

        if(!ObjectUtils.isEmpty(createdDiary))
            return ResponseEntity.ok().body(SUCCESS);
        return ResponseEntity.ok().body(FAIL);
    }

}
