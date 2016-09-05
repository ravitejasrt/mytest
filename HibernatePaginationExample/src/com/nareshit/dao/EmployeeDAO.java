package com.nareshit.dao;

import java.util.List;

import com.nareshit.pojo.Employee;

public interface EmployeeDAO {
public List<Employee> getEmployees(int startRow);
public Long getNoOfEmployees();
}
