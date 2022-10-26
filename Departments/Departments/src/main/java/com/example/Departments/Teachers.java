package com.example.Departments;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="teachers")
public class Teachers {

// private final DepartmentRepository repository;


  @Id
  @GeneratedValue 
  private Integer teach_id;
  private String name;
  private String email;
  private String mobile_num;

 
  @ManyToOne(fetch = FetchType.LAZY) 
  @JoinColumn(name = "departmentId")
  private Department department; 

  Teachers(){
    super();

  }

public Teachers (String name,String email,String mobile_num, Department department){
    this.name =name;
    this.email=email;
    this.mobile_num =mobile_num;
    this.department = department;
    
}
public Integer getTeach_id() {
    return teach_id;
}
public void setTeach_id(Integer teach_id) {
    this.teach_id = teach_id;
}


public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}
public String getMobile_num() {
    return mobile_num;
}
public void setMobile_num(String mobile_num) {
    this.mobile_num = mobile_num;
}

public Department getDepartment() {
    return department;
 }

  public void setDepartment(Department department) {
    this.department = department;
  }



@Override
public boolean equals(Object o){
  if(this == o)
   return true;
   if(!(o instanceof Teachers))
   return false;
   Teachers teacher = (Teachers) o;
   return Objects.equals(this.teach_id, teacher.teach_id) && Objects.equals(this.name, teacher.name)
   && Objects.equals(this.mobile_num, teacher.mobile_num) && Objects.equals(this.department, department);
}
@Override
public int hashCode(){
   return Objects.hash(this.teach_id,this.name,this.mobile_num,this.email);
}
@Override
public String toString() {
    return "Teachers [teacher_id=" + teach_id + ", name=" + name +" email=" + email + ", mobile_num=" + mobile_num + "]";
}



}
