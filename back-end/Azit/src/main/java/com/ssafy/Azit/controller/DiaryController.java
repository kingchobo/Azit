package com.ssafy.Azit.controller;

import com.ssafy.Azit.model.Diary;
import com.ssafy.Azit.model.User;
import com.ssafy.Azit.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // 일기 전체 목록 조회 (로그인 한 아이디의 일기 목록)
    @GetMapping("/list/{userId}")
    public ResponseEntity<List<Diary>> getDiaryList (@PathVariable String userId) {

        System.out.println("----------------");
        System.out.println(userId);
        System.out.println("----------------");
        List<Diary> diaryList = diaryService.listDiary(userId);

        if(!ObjectUtils.isEmpty(diaryList))
            return ResponseEntity.ok().body(diaryList);
        return ResponseEntity.ok().body(diaryList);
    }

}
