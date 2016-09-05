package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.Admin;
import com.util.DBUtility;

public class AdminDao {
   DBUtility dbutility=new DBUtility();
   Connection conn=dbutility.getConnection();

   public Admin getProfileDetails(){	   
	 System.out.println("conn = "+conn);
	 Admin admin=new Admin();
	 Statement stm=null;
	 ResultSet rs=null;
	 try{
	   stm=conn.createStatement();
	   String sql="select * from AdminRegistration where aid='1'";
	   rs=stm.executeQuery(sql);
	   while(rs.next()){
		  admin.setFname(rs.getString("fname"));
		  admin.setLname(rs.getString("lname"));
		  admin.setPhno(rs.getString("phno"));
		  admin.setAddress(rs.getString("address"));
	   }
	 }
	 catch(Exception ex){
		 ex.printStackTrace();
	 }
	 return admin;  
   }
   public List<Admin> getCatgorys(){
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	   
	   List<Admin> listadmn=new ArrayList<Admin>();
	   Statement stm=null;
	   ResultSet rs=null;
	   try{
			   stm=conn.createStatement();
			   String sql="select * from category";
			   rs=stm.executeQuery(sql);
			   while(rs.next()){
				  Admin admin=new Admin();	
				  admin.setCATERGORYID(rs.getString("CATEGORYID"));
				  admin.setCATERGORYNAME(rs.getString("CATEGORYNAME"));
/*                admin.setProdId(rs.getString("productid"));
                  admin.setProdName(rs.getString("productname"));
				  admin.setPRODUCTUNITPRICE(rs.getString("productunitprice"));
				  admin.setPRODUCTCOUNT(rs.getString("PRODUCTCOUNT"));
				  admin.setCATERGORYID(rs.getString("CATERGORYID"));*/
				  listadmn.add(admin);
			   }
			 }
			 catch(Exception ex){
				 ex.printStackTrace();
			 }	   
	   return listadmn;
   }
   public List<Admin> getProducts(){
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	   
	   List<Admin> listadmn=new ArrayList<Admin>();
	   Statement stm=null;
	   ResultSet rs=null;
	   Connection conn=dbutility.getConnection();
	   try{
			   stm=conn.createStatement();
			   String sql="select * from product where CATERGORYID='1' ";
			   rs=stm.executeQuery(sql);
			   while(rs.next()){
				  Admin admin=new Admin();	
				  admin.setCATERGORYID(rs.getString("CATEGORYID"));
				  admin.setCATERGORYNAME(rs.getString("CATEGORYNAME"));
/*                admin.setProdId(rs.getString("productid"));
                  admin.setProdName(rs.getString("productname"));
				  admin.setPRODUCTUNITPRICE(rs.getString("productunitprice"));
				  admin.setPRODUCTCOUNT(rs.getString("PRODUCTCOUNT"));
				  admin.setCATERGORYID(rs.getString("CATERGORYID"));*/
				  listadmn.add(admin);
			   }
			 }
			 catch(Exception ex){
				 ex.printStackTrace();
			 }	   
	   return listadmn;
   }
   
   public List<Admin> getReport(){
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	   
	   List<Admin> listadmn=new ArrayList<Admin>();
	   Statement stm=null;
	   ResultSet rs=null;
	   Connection conn=dbutility.getConnection();
	   try{
			   stm=conn.createStatement();
			   String sql=" select p.PRODUCTNAME,p.PRODUCTDESCIPTION,p.PRODUCTUNITPRICE,p.PRODUCTCOUNT,c.CATNAME	"+
                          " from product p,Catergory c where  c.CATERGORYID=p.CATERGORYID ";
			   rs=stm.executeQuery(sql);
			   while(rs.next()){
				  Admin admin=new Admin();	
                  admin.setProdName(rs.getString("PRODUCTNAME"));
				  admin.setPRODUCTUNITPRICE(rs.getString("PRODUCTUNITPRICE"));
				  admin.setPRODUCTCOUNT(rs.getString("PRODUCTCOUNT"));
				  admin.setCATERGORYNAME(rs.getString("CATNAME"));
				  admin.setPRODUCTDESCIPTION(rs.getString("PRODUCTDESCIPTION"));
				  listadmn.add(admin);
			   }
			 }
			 catch(Exception ex){
				 ex.printStackTrace();
			 }	   
	   return listadmn;
   }
}
