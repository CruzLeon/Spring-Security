package com.courses.study.springsecurity.exc;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String productNotFound) {
        super(productNotFound);
    }
}
