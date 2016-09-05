<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.dao.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.util.*" %>
<%@ page import="com.bean.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    border-radius: 8px;
}

.button1 {
    box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
    border-radius: 8px;
}

.button2:hover {
    box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
    border-radius: 8px;
}
</style>

<style>
tr:hover {
 font-size:110%;
    font-weight: 900;

}

</style>
<style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}
</style>

<body>
     <%@include file="index.jsp" %>

     <h1>Profile Details</h1> 
    <div class="indextab">
<%

 AdminDao admindao=new AdminDao();
 System.out.println("admindao =  "+admindao);
 Admin adm=admindao.getProfileDetails();
 System.out.println("admin =  "+adm);

%>
 <table>
  <tr>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Address</th>
    <th>Phone number</th>
  </tr>
  <tr>
   <th><%=adm.getFname()%></th>
   <th><%=adm.getLname()%></th>
   <th><%=adm.getAddress()%></th>
   <th><%=adm.getPhno()%></th>    
  </tr>
</table>
<button class="button button2">Shadow on Hover</button>

   </div>
</body>
<style>
div.indextab {
    background-color: lightgrey;
    width: 600px;
    border: 1px solid green;
    padding: 25px;
    margin: 25px;
}
</style>
</html>