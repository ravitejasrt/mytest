package com.nareshit.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="employee_details")
public class Employee {
   @Id
   @Column(name="EMPID")
   private Integer empNo;
   @Column(name="ENAME")   
   private String name;
   @Column(name="SAL")   
   private Integer salary;
public Integer getEmpNo() {
	return empNo;
}
public void setEmpNo(Integer empNo) {
	this.empNo = empNo;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getSalary() {
	return salary;
}
public void setSalary(Integer salary) {
	this.salary = salary;
}
   
//	@Id
//private Integer empNo;
//private String name;
//private Double salary;
///**
// * @return the empNo
// */
//public Integer getEmpNo() {
//	return empNo;
//}
///**
// * @param empNo the empNo to set
// */
//public void setEmpNo(Integer empNo) {
//	this.empNo = empNo;
//}
///**
// * @return the name
// */
//public String getName() {
//	return name;
//}
///**
// * @param name the name to set
// */
//public void setName(String name) {
//	this.name = name;
//}
///**
// * @return the salary
// */
//public Double getSalary() {
//	return salary;
//}
///**
// * @param salary the salary to set
// */
//public void setSalary(Double salary) {
//	this.salary = salary;
//}

}
