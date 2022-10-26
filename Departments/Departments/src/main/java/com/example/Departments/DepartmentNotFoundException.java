package com.example.Departments;

public class DepartmentNotFoundException extends RuntimeException {
    DepartmentNotFoundException(Long id) {
        super("Could not find department " + id);
      }
}
