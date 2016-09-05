package com.nareshit.service;

import java.util.List;

import com.nareshit.pojo.Employee;

public interface EmployeeService {
public List<Employee> getEmployees(int pageIndex);
public Long getNoOfPages();
}
