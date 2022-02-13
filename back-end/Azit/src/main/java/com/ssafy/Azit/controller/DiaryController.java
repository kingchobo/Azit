package com.ssafy.Azit.controller;

import com.ssafy.Azit.model.Diary;
import com.ssafy.Azit.model.User;
import com.ssafy.Azit.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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
    @GetMapping("/list")
    public ResponseEntity<List<Diary>> getDiaryList (@RequestParam(name = "userid") String userId, @RequestParam(name = "diarypage") int page) {

        System.out.println("----------------");
        System.out.println(userId);
        System.out.println("----------------");
        List<Diary> diaryList = diaryService.listDiary(userId);

        if(!ObjectUtils.isEmpty(diaryList))
            return ResponseEntity.ok().body(diaryList);
        return ResponseEntity.ok().body(diaryList);
    }

    // 일기 수정
    @PutMapping()
    public ResponseEntity<String> updateDiary (@RequestParam(name="diaryid") long diaryId, @RequestBody Diary diary) {

        Diary getDiary = diaryService.getDiary(diaryId);

        if(!ObjectUtils.isEmpty(getDiary)) {
            diary.setDiaryId(diaryId);
            diaryService.updateDiary(diary);
            return ResponseEntity.ok().body(SUCCESS);
        }
        return ResponseEntity.ok().body(FAIL);
    }

    // 일기 삭제
    @DeleteMapping("/{diaryId}")
    public ResponseEntity<String> deleteDiary (@PathVariable long diaryId) {
        int success = diaryService.deleteDiary(diaryId);

        if(success != 1)
            return ResponseEntity.ok().body(FAIL);
        return ResponseEntity.ok().body(SUCCESS);
    }

}
