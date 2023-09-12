package com.courses.study.springsecurity.controller;

import com.courses.study.springsecurity.model.Customer;
import com.courses.study.springsecurity.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoginController {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        Customer savedCustomer = null;
        ResponseEntity response = null;
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        savedCustomer = customerRepository.save(customer);
        if (savedCustomer.getId() == null) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Cannot save user");
        } else {
            response = ResponseEntity.status(HttpStatus.CREATED)
                    .body("user created");
        }
        return response;
    }
}
