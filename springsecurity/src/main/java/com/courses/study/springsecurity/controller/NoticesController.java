package com.courses.study.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {

    @GetMapping(value = "/notices")
    public String home(){
        return "notices data from DB";
    }
}
