package com.courses.study.springsecurity.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SaveCategory {

    @NotBlank
    private String name;
}
