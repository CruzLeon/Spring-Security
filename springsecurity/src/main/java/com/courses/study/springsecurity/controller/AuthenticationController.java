package com.courses.study.springsecurity.controller;

import com.courses.study.springsecurity.dto.RequestAuth;
import com.courses.study.springsecurity.dto.ResponseAuth;
import com.courses.study.springsecurity.persistence.entity.UserSecondProject;
import com.courses.study.springsecurity.service.impl.AuthenticateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticateService authenticateService;

    @GetMapping("/validate")
    public ResponseEntity<Boolean> validate(@RequestParam String jwt){
        boolean isValid = authenticateService.validateToken(jwt);
        return ResponseEntity.ok().body(isValid);

    }


    @PostMapping("/authenticate")
    public ResponseEntity<ResponseAuth> authenticate(@RequestBody RequestAuth requestAuth){

        ResponseAuth rrs = authenticateService.login(requestAuth);
        return ResponseEntity.ok().body(rrs);

    }

    @GetMapping("/profile")
    public ResponseEntity<UserSecondProject> profile(){
        UserSecondProject userSecondProject = authenticateService.findLoggedUser();
        return ResponseEntity.ok().body(userSecondProject);

    }
}
