package com.courses.study.springsecurity.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RegisteredUser {
   private Integer id;
   private String username;
   private String user;
   private String role;
   private String jwt;
}
