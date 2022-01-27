package com.ssafy.Azit.repository;


import com.ssafy.Azit.model.SampleTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepository extends JpaRepository<SampleTable, Long> {

}
