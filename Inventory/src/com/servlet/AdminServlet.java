package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Admin;
import com.util.DBUtility;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		DBUtility dbu=new DBUtility();
		Connection conn=dbu.getConnection();
		ResultSet rs=null;
		Statement stm=null;
		List<Admin>  listadmn=new ArrayList<Admin>();
	
	    String categoryid=request.getParameter("catid");
	    String pid=request.getParameter("productid");
	    String pricedet=request.getParameter("pricedet");		
	    String qtydet=request.getParameter("qtydet");
/*	    Enumeration<String> enu=request.getParameterNames();
	    System.out.println("------------------------");
	    while(enu.hasMoreElements()){
	      String s=enu.nextElement();	
	      System.out.println(s+" = "+request.getParameter(s));	
	    }
	    System.out.println("------------------------");
*/
//	    System.out.println("categoryid = "+categoryid);
	    if(categoryid!=null & pid==null & pricedet==null & qtydet==null){
		    response.setContentType("text/html");
	//    	response.setContentType("application/json");
 
	    	try{
			   stm=conn.createStatement();
			   String sql="select * from product where CATERGORYID='"+categoryid+"' ";
			   System.out.println("sql = "+sql);
			   rs=stm.executeQuery(sql);
			   String html="";
			   while(rs.next()){
				  Admin admin=new Admin();	
                  admin.setProdId(rs.getString("productid"));
                  admin.setProdName(rs.getString("productname"));
                  html+="<option value="+admin.getProdId()+">"+admin.getProdName()+"</option><td>";
			//	  listadmn.add(admin);
			   }
			   pw.println(html);
	       }
	       catch(Exception ex){
	    	ex.printStackTrace();
	       }
	    }
	    
	    if(categoryid!=null & pid!=null & pricedet!=null & qtydet!=null){
		    response.setContentType("text/html");
			int count=0;
			Statement stm1=null;
	//		String sql="update product set PRODUCTUNITPRICE='"+pricedet+"' , PRODUCTCOUNT='"+qtydet+"' WHERE PRODUCTID='"+pid+"' AND CATERGORYID='"+categoryid+"'";
			String sql=" UPDATE product "+
                " set PRODUCTUNITPRICE='"+pricedet+"' , PRODUCTCOUNT='"+qtydet+"'"+
                " where PRODUCTID='"+pid+"' and CATERGORYID='"+categoryid+"'";
			try{
			  System.out.println("sql = "+sql);
			  stm1=conn.createStatement();
			  count=stm1.executeUpdate(sql);		
			  conn.commit();
			  String html="worest";
			  if(count==1){
				html="successfully";		
			  }
			  else{
				html="un successfully";						  
			  }
			  pw.println(html);

			} 

			catch(Exception e){
			 e.printStackTrace();
			}
	    }
	    String catidnp=request.getParameter("catidnp");
	    String addproduct=request.getParameter("addproduct");
	    System.out.println("catidnp = "+catidnp);
	    System.out.println("addproduct = "+addproduct);

	    if(addproduct!=null & catidnp!=null){
		    response.setContentType("text/html");
			int count=0;
			Statement stm1=null;
			Statement stmseq=null;
			String sqlseq="select add_product_seq.NEXTVAL from dual";
			int prod_id=0;
			try{
				stmseq=conn.createStatement();
				ResultSet rsseq = stmseq.executeQuery(sqlseq);
				if (rsseq.next() ) {
				 prod_id = rsseq.getInt(1);
    			 conn.commit();
				 System.out.println("prod_id = "+prod_id);
    			 rsseq.close();
				}	
			}
			catch(Exception e){
				e.printStackTrace();
			}
			String sql=" insert into product(PRODUCTID,CATERGORYID,PRODUCTNAME) values('"+prod_id+"','"+catidnp+"','"+addproduct+"') ";
			try{
			  System.out.println("sql(insert) = "+sql);
			  stm1=conn.createStatement();
			  count=stm1.executeUpdate(sql);  
			  conn.commit();
			  String html="worest";
			  if(count==1){
				html="successfully";		
			  }
			  else{
				html="un successfully";						  
			  }
			  pw.println(html);

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
