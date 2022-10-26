package com.example.Departments;
import java.util.List;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
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
public class    TeachersController {
   TeachersRepository repository;
    TeachersController(TeachersRepository repository){
        this.repository =repository;
    }
     // Aggregate root a class which works as an entry point to our aggregate
     // tag::get-aggregate-root[]
    @GetMapping("/teachers")
        public List<Teachers> all() {
            return repository.findAll();
    }
    // end::get-aggregate-root[]
    // @GetMapping("/departments/{departmentid}/teachers")
    // public ResponseEntity<List<Teachers>> getAllTeachersInDepartmentId(@PathVariable(value="departmentid") Long departmentid){
    // if(!repository.existsById(departmentid)){
    //       throw new TeachersNotFoundException(departmentid);      
    // } 
    //  List<Teachers> teachers = TeachersRepository.findByDepartmentId(departmentid); 
    //  return new ResponseEntity<>(teachers,HttpStatus.OK);
    // }
    /**
     * @param id
     * @return
     */
    @GetMapping("/teachers/{teach_id}")
    Teachers one(@PathVariable Long id){
        return repository.findById(id) 
           .orElseThrow(() -> new TeachersNotFoundException(id));      
    }
    
    @PostMapping("/teachers")
    Teachers newTeachers(Teachers newTeachers){
        return repository.save(newTeachers);
    }
   
    
    @PutMapping("/teachers/{teach_id}")
    Teachers replaceTeachers(@RequestBody Teachers newTeachers,@PathVariable Long id){
       return repository.findById(id)
       //Map represents a mapping between a key and a value
        .map(Teachers ->{
          Teachers.setName(Teachers.getName());
          Teachers.setMobile_num(Teachers.getMobile_num());
          Teachers.setEmail(Teachers.getEmail());
          return repository.save(Teachers);
        })
        .orElseGet(() ->{
          newTeachers.setTeach_id(id.intValue());
          return repository.save(newTeachers);
        });
    
    }
    @PatchMapping("/teachers/{teach_id}")
    Teachers updateTeachers(@RequestBody Teachers newTeachers,@PathVariable Long id){
    Teachers user = repository.findById(id)
      .orElseThrow(() -> new TeachersNotFoundException(id));
    user.setName(newTeachers.getName());
    return repository.save(user);
    }
    @DeleteMapping("/teachers/{teach_id}")
    void deleteTeachers(@PathVariable Long id){
        repository.deleteById(id);
    }


}

