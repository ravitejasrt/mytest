package com.bean;

public class Admin {
  private String prodId;
  private String prodName;  
  private String PRODUCTUNITPRICE;
  private String PRODUCTCOUNT;
  private String CATERGORYID;
  private String CATERGORYNAME;
  private String PRODUCTDESCIPTION;
  
  private String fname;
  private String lname;
  private String address;
  private String phno;

  
  
  public String getPRODUCTDESCIPTION() {
	return PRODUCTDESCIPTION;
}
public void setPRODUCTDESCIPTION(String pRODUCTDESCIPTION) {
	PRODUCTDESCIPTION = pRODUCTDESCIPTION;
}
public String getCATERGORYNAME() {
	return CATERGORYNAME;
}
public void setCATERGORYNAME(String cATERGORYNAME) {
	CATERGORYNAME = cATERGORYNAME;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPhno() {
	return phno;
}
public void setPhno(String phno) {
	this.phno = phno;
}
public String getPRODUCTUNITPRICE() {
	return PRODUCTUNITPRICE;
}
public void setPRODUCTUNITPRICE(String pRODUCTUNITPRICE) {
	PRODUCTUNITPRICE = pRODUCTUNITPRICE;
}
public String getPRODUCTCOUNT() {
	return PRODUCTCOUNT;
}
public void setPRODUCTCOUNT(String pRODUCTCOUNT) {
	PRODUCTCOUNT = pRODUCTCOUNT;
}
public String getCATERGORYID() {
	return CATERGORYID;
}
public void setCATERGORYID(String cATERGORYID) {
	CATERGORYID = cATERGORYID;
}
public String getProdId() {
	return prodId; 
  }
  public void setProdId(String prodId) {
	this.prodId = prodId;
  }
  public String getProdName() {
	return prodName;
  }
  public void setProdName(String prodName) {
	this.prodName = prodName;
  }
}
