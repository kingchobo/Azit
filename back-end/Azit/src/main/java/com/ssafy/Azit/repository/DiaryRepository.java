package com.ssafy.Azit.repository;

import com.ssafy.Azit.model.Diary;
import com.ssafy.Azit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {

    Optional<Diary> findByDiaryId(long diaryId);
    List<Diary> findByTitleContaining(String title);
}
