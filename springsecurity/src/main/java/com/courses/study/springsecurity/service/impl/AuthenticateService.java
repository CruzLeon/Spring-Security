package com.courses.study.springsecurity.service.impl;

import com.courses.study.springsecurity.dto.RegisteredUser;
import com.courses.study.springsecurity.dto.RequestAuth;
import com.courses.study.springsecurity.dto.ResponseAuth;
import com.courses.study.springsecurity.dto.SaveUser;
import com.courses.study.springsecurity.persistence.entity.UserSecondProject;
import com.courses.study.springsecurity.service.UserService;
import com.courses.study.springsecurity.service.mapper.EntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticateService {

    private final EntityMapper mapper;
    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public RegisteredUser registerOneCustomer(SaveUser newUser) {
        UserSecondProject user = userService.registerOneCustomer(newUser);
        RegisteredUser rs = mapper.mapTo(user);
        rs.setUser(user.getName());
        rs.setJwt(jwtService.generateToken(user, extraClaims(user)));
        return rs;
    }

    private Map<String, Object> extraClaims(UserSecondProject user) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name", user.getName());
        extraClaims.put("role", user.getRole().toString());
        extraClaims.put("authorities", user.getAuthorities());
        return extraClaims;
    }

    public ResponseAuth login(RequestAuth requestAuth) {
        UsernamePasswordAuthenticationToken rq = new UsernamePasswordAuthenticationToken(requestAuth.getUsername(), requestAuth.getPassword());
        authenticationManager.authenticate(rq);
        UserSecondProject userSecondProject = userService.findOneByUsername(requestAuth.getUsername()).get();
        String jwt = jwtService.generateToken(userSecondProject, extraClaims(userSecondProject));
        ResponseAuth rs = new ResponseAuth();
        rs.setJwt(jwt);
        return rs;
    }

    public boolean validateToken(String jwt) {
        return !jwtService.extractUsername(jwt).isEmpty();
    }

    public UserSecondProject findLoggedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth instanceof UsernamePasswordAuthenticationToken usernametoken){
            String username = usernametoken.getName();
            return userService.findOneByUsername(username).get();
        }
        throw new IllegalStateException();
    }
}
