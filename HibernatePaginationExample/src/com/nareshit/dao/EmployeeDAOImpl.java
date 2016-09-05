package com.nareshit.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.nareshit.pojo.Employee;
import com.nareshit.util.HibernateUtility;
import com.nareshit.util.PaginationConstants;

public class EmployeeDAOImpl implements EmployeeDAO {

	
public List<Employee> getEmployees(int startRow) {
Session session=HibernateUtility.getSession();	
String hql="from com.nareshit.pojo.Employee";
Query query=session.createQuery(hql);
	query.setFirstResult(startRow);
	query.setMaxResults(PaginationConstants.CONST_MAX_ROWS);
       List<Employee> list= query.list();
       session.close();
	return list;
	}
public Long getNoOfEmployees() {
	Session session=HibernateUtility.getSession();	
String hql="select count(*) from com.nareshit.pojo.Employee";
	Query query=session.createQuery(hql);
  Long  count=(Long)query.uniqueResult();
	session.close();
		return count;
	}
}





