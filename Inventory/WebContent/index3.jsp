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
<body>
        <%@include file="index.jsp" %>

   <h1>index3</h1>
<div class="indextab">
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
}

.button1 {
    background-color: white;
    color: black;
    border: 2px solid #4CAF50;
}

.button2 {
    background-color: white;
    color: black;
    border: 2px solid #008CBA;
}

.button3 {
    background-color: white;
    color: black;
    border: 2px solid #f44336;
}



.button4:hover {
    background-color: #555555;
    color: white;
}
</style>


<h2>Colored Button Borders</h2>
<p>Use the border property to add a border to the button:</p>

<button class="button button1">Green</button>
<button class="button button2">Blue</button>
<button class="button button3">Red</button>
<button class="button button4">Gray</button>
<button class="button button5">Black</button>
   
   
   
   
<style>
#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#customers td, #customers th {
    border: 1px solid #ddd;
    text-align: left;
    padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2}

#customers tr:hover {background-color: #ddd;}

#customers th {
    padding-top: 12px;
    padding-bottom: 12px;
    background-color: #4CAF50;
    color: white;
}
</style>
  <style>
tr:hover {font-size:110%;}

</style> 

<%
   AdminDao admindao=new AdminDao();
   List<Admin> adminlst=admindao.getReport();

%>
<table id="customers">
  <tr>
    <th>Product Name</th>
    <th>Product Description</th>
    <th>Price</th>
    <th>Count</th>
    <th>Category</th>
  </tr>
  
  <% for(int i=0;i<adminlst.size();i++){%>
  <tr>
   <td><%=adminlst.get(i).getProdName()%></td>
   <td><%=adminlst.get(i).getPRODUCTDESCIPTION() %></td>
   <td><%=adminlst.get(i).getPRODUCTUNITPRICE()%></td>
   <td><%=adminlst.get(i).getPRODUCTCOUNT()%></td>
   <td><%=adminlst.get(i).getCATERGORYNAME()%></td>
 </tr>
 <% } %> 
  
</table>
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