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
@Table(name="students")
public class Students {

  private @Id @GeneratedValue Long stud_id;
  private String name;
  private String email;
  private String mobile_num;
 
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "departmentId")
  private Department id; 
  Students(){

  }

Students (String name,String email,String mobile_num){
    this.name =name;
    this.email=email;
    this.mobile_num =mobile_num;
    
   
}
public Long getStud_id() {
    return stud_id;
}
public void setStud_id(Long stud_id) {
    this.stud_id = stud_id;
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



@Override
public boolean equals(Object o){
  if(this == o)
   return true;
   if(!(o instanceof Students))
   return false;
   Students students = (Students) o;
   return Objects.equals(this.stud_id, students.stud_id) && Objects.equals(this.name, students.name)
   && Objects.equals(this.mobile_num, students.mobile_num) ;
}
@Override
public int hashCode(){
   return Objects.hash(this.stud_id,this.name,this.mobile_num,this.email);
}
@Override
public String toString() {
    return "Students [ student_id=" + stud_id + ", name=" + name +" email=" + email + ", mobile_num=" + mobile_num + "]";
}

}
