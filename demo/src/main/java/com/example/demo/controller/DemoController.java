package com.example.demo.controller;

import com.example.demo.common.Coach;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reza.jac.TestBean;

@RestController
public class DemoController {

    //define a private field for the dependency
    private final Coach myCoach;
    private final Coach anotherCoach;

    private Coach swimCoach;

    RestTemplate template ;

    @Autowired
    public void setTemplate(RestTemplate template){
        this.template = template;
    }


    @Autowired
    private TestBean testBean;

    //dependency injection by constructor
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach coach,
                          @Qualifier("cricketCoach") Coach secondCoach,
                          @Qualifier("aquatic")Coach swimCoach){
        myCoach = coach;
        anotherCoach = secondCoach;
        this.swimCoach = swimCoach;
    }

//    @Autowired
//    public void SetMyDesiredCoach(Coach coach){
//        this.myCoach = coach;
//    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        testBean.doSomeThing();
        return myCoach.getDailyWorkOut();
    }

    @GetMapping("/swimdailyworkout")
    public String getSwimDailyWorkout(){
        return swimCoach.getDailyWorkOut();
    }


    @GetMapping("/check")
    public String check(){
        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }
}
