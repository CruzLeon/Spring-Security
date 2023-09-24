package com.courses.study.springsecurity.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ApiError {

    private String backendMessage;
    private String message;
    private String url;
    private String method;
    private LocalDateTime timestamp;
}
