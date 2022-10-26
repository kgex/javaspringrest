package com.example.Departments;

public class StudentsNotFoundException  extends RuntimeException {
    StudentsNotFoundException (Long id) {
       super ("Could not find student " + id);
      }
}