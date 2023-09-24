package com.courses.study.springsecurity.exc;

import com.courses.study.springsecurity.dto.ApiError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGenericException(Exception e, HttpServletRequest request) {
        ApiError error = new ApiError();
        error.setBackendMessage(e.getMessage());
        error.setUrl(request.getRequestURL().toString());
        error.setMethod(request.getMethod());
        error.setTimestamp(LocalDateTime.now());
        error.setMessage("Error interno en el servidor vuelva a intentarlo");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(Exception e, HttpServletRequest request) {
        ApiError error = new ApiError();
        error.setBackendMessage(e.getMessage());
        error.setUrl(request.getRequestURL().toString());
        error.setMethod(request.getMethod());
        error.setTimestamp(LocalDateTime.now());
        error.setMessage("Error en la peticion enviada");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
