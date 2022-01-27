package com.ssafy.Azit.controller;

import com.ssafy.Azit.model.SampleTable;
import com.ssafy.Azit.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class SampleController {

    @Autowired
    private SampleRepository sampleRepository;

    @GetMapping("/sample/{id}")
    public Optional<SampleTable> getSample(@PathVariable Long id){
        return sampleRepository.findById(id);
    }

    @PostMapping("/sample")
    public SampleTable createSample(@RequestBody SampleTable sampleTable){
        return sampleRepository.save(sampleTable);
    }

}
