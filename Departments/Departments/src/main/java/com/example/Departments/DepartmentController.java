package com.example.Departments;
import java.util.List;


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

public class DepartmentController {
    private final DepartmentRepository repository;
    DepartmentController(DepartmentRepository repository){
        this.repository =repository;
    }
     // Aggregate root a class which works as an entry point to our aggregate
     // tag::get-aggregate-root[]
    @GetMapping("/departments")
        public List<Department> all() {
            return repository.findAll();
    }
    // end::get-aggregate-root[]

    @GetMapping("/departments/{id}")
    Department one(@PathVariable Long id){
        return repository.findById(id)
           .orElseThrow(() -> new DepartmentNotFoundException(id));      
    }
    //RequestBody allows us to retrieve the request's body( data sent by the client to your API). You will get your values mapped with the model you created in your system for handling any specific call.
    @PostMapping("/departments")
    Department newDepartment(@RequestBody Department newDepartment){
        return repository.save(newDepartment);
    }
    @PutMapping("/department/{id}")
    Department replaceDepartment(@RequestBody Department newDepartment, @PathVariable Long id){
       return repository.findById(id)
       //Map represents a mapping between a key and a value
        .map(department ->{
          department.setName(department.getName());
          department.setDescription(department.getDescription());
          return repository.save(department);
        })
        .orElseGet(() ->{
          newDepartment.setDepartmentId(id.intValue());
          return repository.save(newDepartment);
        });
    
    }
    @PatchMapping("/department/{id}")
    Department updateDepartment(@RequestBody Department newDepartment,@PathVariable Long id){
    Department dept = repository.findById(id)
      .orElseThrow(() -> new DepartmentNotFoundException(id));
    dept.setName(newDepartment.getName());
    return repository.save(dept);
    }
    @DeleteMapping("/department/{id}")
    void deleteDepartment(@PathVariable Long id){
        repository.deleteById(id);
    }


}
