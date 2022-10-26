package com.example.Departments;

public class TeachersNotFoundException extends RuntimeException {
    TeachersNotFoundException(Long id) {
       super ("Could not find teacher " + id);
      }
}
