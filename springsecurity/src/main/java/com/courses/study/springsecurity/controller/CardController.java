package com.courses.study.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

    @GetMapping(value = "/my-cards")
    public String home(){
        return "cards data from DB";
    }
}
