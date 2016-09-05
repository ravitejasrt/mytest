package com.nareshit.dao.factory;

import com.nareshit.dao.EmployeeDAO;
import com.nareshit.dao.EmployeeDAOImpl;

public class DAOFactory {
private static EmployeeDAO employeeDAO;

static {
	employeeDAO=new EmployeeDAOImpl();
}
public static EmployeeDAO getEmployeeDAO(){
	return employeeDAO;
}
}
