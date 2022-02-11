package com.ssafy.Azit.repository;

import com.ssafy.Azit.model.DiaryGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaryGroupRepository extends JpaRepository<DiaryGroup, Long> {
}
