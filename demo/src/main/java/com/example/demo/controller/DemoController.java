package com.example.demo.controller;

import com.example.demo.common.Coach;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //define a private field for the dependency
    private final Coach myCoach;

    //dependency injection by constructor
    @Autowired
    public DemoController(Coach coach){
        myCoach = coach;
    }


    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkOut();
    }
}
