package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Admin;
import com.util.DBUtility;
@WebServlet("/GetProducts")

public class GetProducts extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 DBUtility dbu=new DBUtility();
		 try{
			 PrintWriter out=response.getWriter();
			 response.setContentType("text/html");
			 Connection conn=dbu.getConnection();
		   String catgeid=request.getParameter("catgeid");
		   System.out.println("catgeid = "+catgeid);
			 if(catgeid!=null){
			  try{
				   out.println("conn = "+conn);
				   out.println("catgeid = "+catgeid);
				   Statement stm1=conn.createStatement();
				   String sql1="select * from product  where CATERGORYID='1' ";
				   ResultSet rs1=stm1.executeQuery(sql1);
				   List listmenu2=new ArrayList<String>();
		         if(rs1.next()){
		      	  Admin admin=new Admin();
		      	  admin.setProdId(rs1.getString("PRODUCTID"));
		      	  admin.setProdName(rs1.getString("PRODUCTNAME"));
		      	  admin.setPRODUCTCOUNT(rs1.getString("PRODUCTCOUNT"));
		      	  admin.setPRODUCTUNITPRICE(rs1.getString("PRODUCTUNITPRICE"));
		      	  admin.setCATERGORYID(rs1.getString("CATERGORYID"));
		      	  listmenu2.add(admin);
		      	  
		      	 
		      	  out.println("rs1.getString() = "+rs1.getString("PRODUCTID"));
		      	  out.println("listmenu2 = "+rs1.getString("PRODUCTNAME"));
		      	  
				  }
			  }
				  catch(Exception e){
					  e.printStackTrace();
				  }
			 }
		 }finally{}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
