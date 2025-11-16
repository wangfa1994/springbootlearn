package com.wf.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class CommonException {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("coming exception ......."+e.getMessage());
        return ResponseEntity.ok(e.getMessage());
    }


}
