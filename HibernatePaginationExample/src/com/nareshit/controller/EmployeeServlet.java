package com.nareshit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nareshit.pojo.Employee;
import com.nareshit.service.EmployeeService;
import com.nareshit.service.EmployeeServiceImpl;

public class EmployeeServlet extends HttpServlet{
	private EmployeeService employeeService;
	public void init(){
	employeeService=new EmployeeServiceImpl();
	}
public void doGet(HttpServletRequest req,
		HttpServletResponse  res)throws IOException,ServletException{
	Integer pageIndex=0;
	String pi=req.getParameter("pageIndex");
	if(pi==null){
		pageIndex=1;
	}else{
	pageIndex=Integer.parseInt(pi);
	}
List<Employee> listOfEmployees
=employeeService.getEmployees(pageIndex);
	Long noOfPages=employeeService.getNoOfPages();
req.setAttribute("list",listOfEmployees);
req.setAttribute("noOfPages",noOfPages);
String tagerView="/WEB-INF/pages/employeeResults.jsp";
RequestDispatcher rd=req.getRequestDispatcher(tagerView);
  rd.forward(req,res);
}
}




