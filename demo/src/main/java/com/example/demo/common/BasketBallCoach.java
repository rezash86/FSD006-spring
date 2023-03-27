package com.example.demo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BasketBallCoach implements Coach {

    public BasketBallCoach() {
        System.out.println("In constructor " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkOut() {
        {
            return "Practice every day for 40 min";
        }
    }
}
