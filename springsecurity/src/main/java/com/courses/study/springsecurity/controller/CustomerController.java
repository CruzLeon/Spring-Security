package com.courses.study.springsecurity.controller;

import com.courses.study.springsecurity.dto.RegisteredUser;
import com.courses.study.springsecurity.dto.SaveUser;
import com.courses.study.springsecurity.service.impl.AuthenticateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final AuthenticateService authenticateService;

    @PostMapping
    public ResponseEntity<RegisteredUser> registerOne(@RequestBody SaveUser newUser) {
        RegisteredUser registeredUser = authenticateService.registerOneCustomer(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    }
}
