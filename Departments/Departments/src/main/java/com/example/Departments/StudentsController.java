package com.example.Departments;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//RestController is used for making restful web services with the help of the @RestController annotation. This annotation is used at the class level and allows the class to handle the requests made by the client.
@RestController
public class StudentsController {
    private final StudentsRepository repository;
    StudentsController(StudentsRepository repository){
        this.repository =repository;
    }
     // Aggregate root a class which works as an entry point to our aggregate
     // tag::get-aggregate-root[]
    @GetMapping("/students")
        public List<Students> all() {
            return repository.findAll();
    }
    // end::get-aggregate-root[]
    /**
     * @param departmentid
     * @return
     */
    @GetMapping("/departments/{departmentid}/students")
    public ResponseEntity<List<Students>> getAllStudentsInDepartmentId(@PathVariable(value="departmentid") Long departmentid){
    if(!repository.existsById(departmentid)){
          throw new StudentsNotFoundException(departmentid);      
    } 
     List<Students> students = StudentsRepository.findByDepartmentId(departmentid); 
     return new ResponseEntity<>(students,HttpStatus.OK);
    }
    
    @GetMapping("/students/{stud_id}")
    Students one(@PathVariable Long id){
        return repository.findById(id)
           .orElseThrow(() -> new StudentsNotFoundException(id));      
    }
    //RequestBody allows us to retrieve the request's body( data sent by the client to your API). You will get your values mapped with the model you created in your system for handling any specific call.
    @PostMapping("/Students")
    Students newStudents(@RequestBody Students newStudents){
        return repository.save(newStudents);
    }
    @PutMapping("/Students/{stud_id}")
    Students replaceStudents(@RequestBody Students newStudents,@PathVariable Long id){
       return repository.findById(id)
       //Map represents a mapping between a key and a value
        .map(Students ->{
          Students.setName(Students.getName());
          Students.setMobile_num(Students.getMobile_num());
          Students.setEmail(Students.getEmail());
          return repository.save(Students);
        })
        .orElseGet(() ->{
          newStudents.setStud_id(id);
          return repository.save(newStudents);
        });
    
    }
    @PatchMapping("/students/{stud_id}")
    Students updateStudents(@RequestBody Students newStudents,@PathVariable Long id){
    Students user = repository.findById(id)
      .orElseThrow(() -> new StudentsNotFoundException(id));
    user.setName(newStudents.getName());
    return repository.save(user);
    }
    @DeleteMapping("/students/{stud_id}")
    void deleteStudents(@PathVariable Long id){
        repository.deleteById(id);
    }


}


