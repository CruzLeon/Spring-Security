package com.courses.study.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {

    @GetMapping(value = "/my-balance")
    public String home(){
        return "balance data from DB";
    }
}
