package com.courses.study.springsecurity.config;

import com.courses.study.springsecurity.model.Customer;
import com.courses.study.springsecurity.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomUserDetails implements UserDetailsService {

    private final CustomerRepository customerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName, password = null;
        List<GrantedAuthority> authorityList;
        List<Customer> customers = customerRepository.findByEmail(username);

        if(customers.isEmpty()) throw new UsernameNotFoundException("User not found");

        userName=customers.get(0).getEmail();
        password=customers.get(0).getPassword();
        authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority(customers.get(0).getRole()));

        return new User(userName, password, authorityList);
    }
}
