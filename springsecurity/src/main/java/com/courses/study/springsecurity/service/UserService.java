package com.courses.study.springsecurity.service;

import com.courses.study.springsecurity.dto.SaveProduct;
import com.courses.study.springsecurity.dto.SaveUser;
import com.courses.study.springsecurity.persistence.entity.Product;
import com.courses.study.springsecurity.persistence.entity.UserSecondProject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

public interface UserService {

    UserSecondProject registerOneCustomer(SaveUser newUser);

    Optional<UserSecondProject> findOneByUsername(String username);
}
