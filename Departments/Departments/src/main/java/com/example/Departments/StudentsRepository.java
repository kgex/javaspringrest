package com.example.Departments;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentsRepository extends JpaRepository<Students,Long>{

    static List<Students> findByDepartmentId(Long id) {
        return null;
    }
    /**
 * @param id
 * @return
 */
static List<Students>  getAllStudentsInDepartmentId(Long id){
    return null;
}

    /**
 *
 */

    

          
}
