package com.courses.study.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {

    @GetMapping(value = "/my-loans")
    public String home(){
        return "loan data from DB";
    }
}
