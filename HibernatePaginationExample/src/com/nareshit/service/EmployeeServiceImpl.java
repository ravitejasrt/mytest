package com.nareshit.service;

import java.util.List;

import com.nareshit.dao.EmployeeDAO;
import com.nareshit.dao.factory.DAOFactory;
import com.nareshit.pojo.Employee;
import com.nareshit.util.PaginationConstants;

public class EmployeeServiceImpl implements EmployeeService{
	public List<Employee> getEmployees(int pageIndex) {
		
int startRow=(pageIndex-1)*PaginationConstants.CONST_MAX_ROWS;
EmployeeDAO employeeDAO=DAOFactory.getEmployeeDAO();
		List<Employee> list=employeeDAO.getEmployees(startRow);
		
		return list;
	}


	public Long getNoOfPages() {
  EmployeeDAO empDao=DAOFactory.getEmployeeDAO();
	  Long noOfEmployees=empDao.getNoOfEmployees();
	  Long noOfPages=noOfEmployees/PaginationConstants.CONST_MAX_ROWS;
	  if (noOfEmployees > (noOfPages * PaginationConstants.CONST_MAX_ROWS)) {
			noOfPages++;
		}
  return noOfPages;
	}

}
