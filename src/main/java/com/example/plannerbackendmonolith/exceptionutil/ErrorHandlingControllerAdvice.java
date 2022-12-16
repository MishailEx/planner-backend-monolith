package com.example.plannerbackendmonolith.exceptionutil;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ErrorHandlingControllerAdvice {

//    @ExceptionHandler(ConstraintViolationException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    ValidationErrorResponse onConstraintValidationException(
//            ConstraintViolationException e) {
//        ValidationErrorResponse error = new ValidationErrorResponse();
//        for (ConstraintViolation violation : e.getConstraintViolations()) {
//            error.getViolations().add(
//                    new Violation(violation.getPropertyPath().toString(), violation.getMessage()));
//        }
//        return error;
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationErrorResponse validError(MethodArgumentNotValidException e) {
         List<Violation> violations = e.getBindingResult().getFieldErrors().stream()
                .map(error -> new Violation(error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());
        return new ValidationErrorResponse(violations);
    }
}
