package com.jac.mvcproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoThymeleafController {

    @GetMapping("/")
    public String sayHello(Model theModel){
        theModel.addAttribute("myDate", new java.util.Date());

        return "helloworld";
    }
}
