package com.example.Departments;



import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
 import javax.persistence.JoinColumn;
 import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="department")

class Department {
    
    @Id 
    @GeneratedValue 
    @Column(name="departmentId")
    private int departmentId;
    private String name;
    private String description;

    Department(){ 
    }

    Department(String name,String description){
        this.name =name;
        this.description =description;
    }
  
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    //  @OneToMany(cascade = CascadeType.ALL)
    //  @JoinColumn(name="fk_dept_id",referencedColumnName = "dept_id")
    //  private List <Teachers> teachersList;

    //we have method equals to override we use this
    @Override
    public boolean equals(Object o){
    if(this==o) //to check current we use this
    return true;
    if(!(o instanceof Department))      
    return false;
    Department department=(Department) o;
    return Objects.equals(this.departmentId,department.departmentId) && Objects.equals(this.name,department.name) && Objects.equals(this.description,department.description) ;
        
}
//computes hash value(numeric value of fixed length) of given data
    @Override
    public int hashCode(){
        return Objects.hash(this.departmentId, this.name, this.description);
    }
    @Override
    public String toString() {
         return "Department [id=" + departmentId + ", name=" + name + ", description=" + description + "]";//"techers"+ teachersList+
    }
   

}

