package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Admin;
import com.util.DBUtility;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("/ActionServlet")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		 response.setContentType("text/html");

		DBUtility dbu=new DBUtility();
		Connection conn1=dbu.getConnection();
		String prodid=request.getParameter("prodid");
		String catid=request.getParameter("catid");
		if(catid!=null & prodid!=null){
			  try{
				   System.out.println("conn = "+conn1);
				   Statement stm1=conn1.createStatement();
				   String sql1="select * from  product where CATERGORYID='1' ";
				   ResultSet rs1=stm1.executeQuery(sql1);
				   List listcp=new ArrayList<String>();
		           if(rs1.next()){
					   Admin admin=new Admin();
		        	   admin.setProdId(rs1.getString("PRODUCTID"));
		        	   admin.setProdName(rs1.getString("PRODUCTNAME"));
		        	   listcp.add(admin);
		           }
		           
				  }
				  catch(Exception e){
					  e.printStackTrace();
				  }
			
		}
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
//		  try{
//		   System.out.println("conn = "+conn1);
//		   Statement stm1=conn1.createStatement();
//		   String sql1="update product set PRODUCTUNITPRICE='' and PRODUCTCOUNT='' where CATERGORYID='1' ";
//		   int rs1=stm1.executeUpdate(sql1);
//		   List list=new ArrayList<String>();
//           if(rs1==1){
//        	   
//           }
//           
//		  }
//		  catch(Exception e){
//			  e.printStackTrace();
//		  }

		 String menu2text=request.getParameter("menu2text") ;
		 if(menu2text!=null){
		  try{
			   System.out.println("conn = "+conn1);
			   System.out.println("menu2text = "+menu2text);
			   Statement stm1=conn1.createStatement();
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
	           }
	           
			  }
			  catch(Exception e){
				  e.printStackTrace();
			  }
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
