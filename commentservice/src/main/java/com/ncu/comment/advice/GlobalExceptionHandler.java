package com.ncu.comment.advice;

import com.ncu.comment.dto.APIResponse;
import com.ncu.comment.service.exceptions.ResourceNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse<?>> handleResourceNotFound(ResourceNotFoundException ex) {
        return new ResponseEntity<>(
                new APIResponse<>(ex.getMessage(), null, false),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponse<?>> handleOtherExceptions(Exception ex) {
        return new ResponseEntity<>(
                new APIResponse<>(ex.getMessage(), null, false),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
