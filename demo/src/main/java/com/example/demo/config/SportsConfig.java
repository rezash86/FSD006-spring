package com.example.demo.config;

import com.example.demo.common.Coach;
import com.example.demo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SportsConfig {

    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }

    @Bean
    public RestTemplate template(){
        return new RestTemplate();
    }
}
