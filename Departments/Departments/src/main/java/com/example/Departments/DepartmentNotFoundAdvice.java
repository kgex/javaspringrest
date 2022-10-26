package com.example.Departments;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//ControllerAdvice allows to handle exceptions across the whole application in one global handling component.
@ControllerAdvice
public class DepartmentNotFoundAdvice {
  @ResponseBody
  @ExceptionHandler(DepartmentNotFoundException.class)  
  @ResponseStatus(HttpStatus.NOT_FOUND) 
  String departmentNotFoundHandler(DepartmentNotFoundException ex) {
    return ex.getMessage();
  }
}
