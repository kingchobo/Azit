package com.ssafy.Azit.repository;

import com.ssafy.Azit.model.Emotions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmotionsRepository extends JpaRepository<Emotions, Long>{

}
