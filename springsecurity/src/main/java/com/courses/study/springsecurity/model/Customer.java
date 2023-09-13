package com.courses.study.springsecurity.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "customer")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Integer id;
    private String email;

    @Column(name = "usern")
    private String user;
    @Column(name = "pass")
    private String password;
    private String role;
}
