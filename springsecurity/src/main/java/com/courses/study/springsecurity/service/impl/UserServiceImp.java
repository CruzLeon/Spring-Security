package com.courses.study.springsecurity.service.impl;

import com.courses.study.springsecurity.dto.SaveUser;
import com.courses.study.springsecurity.persistence.UserRepository;
import com.courses.study.springsecurity.persistence.entity.Role;
import com.courses.study.springsecurity.persistence.entity.UserSecondProject;
import com.courses.study.springsecurity.service.UserService;
import com.courses.study.springsecurity.service.mapper.EntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final EntityMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public UserSecondProject registerOneCustomer(SaveUser newUser) {
        validatePassword(newUser);
        UserSecondProject userSecondProject = mapper.mapTo(newUser);
        userSecondProject.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userSecondProject.setRole(Role.ROLE_CUSTOMER);
        return userRepository.save(userSecondProject);
    }

    @Override
    public Optional<UserSecondProject> findOneByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    private void validatePassword(SaveUser newUser) {
        if (newUser.getPassword() == null || newUser.getRepeatedPassword() == null) {
            throw new IllegalStateException();
        }
        if (!(newUser.getPassword().equals(newUser.getRepeatedPassword()))) {
            throw new IllegalStateException();
        }

    }


}
