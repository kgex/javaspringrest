package com.example.Departments;
// import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TeachersRepository extends JpaRepository<Teachers,Long>{

    
     /**
      * @param id
      * @return
      */
     // static List<Teachers> findByDepartmentId(Long id) {
          
     //      return null;
     // }
   
     //      /**
     //       * @param id
     //       * @return
     //       */
     // static  List<Teachers>  getAllTeachersInDepartmentId(Long id){
     //      return null;
     // }

        
    
     
    
}
