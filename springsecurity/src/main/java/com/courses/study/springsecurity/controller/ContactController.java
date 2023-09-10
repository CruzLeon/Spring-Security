package com.courses.study.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @GetMapping(value = "/contact")
    public String home(){
        return "contact data from DB";
    }
}
