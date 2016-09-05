<%@page 
import="java.util.List,com.nareshit.pojo.Employee" %>

<%!
Long noOfPages=null;
List<Employee> list=null;
String myURL=null;
%>

<%
 list=(List<Employee>)request.getAttribute("list");
  noOfPages=(Long)request.getAttribute("noOfPages");
%>
<div align="center" style="margin-top: 100px">
<table border="1">
<tr><th>EmpNo</th><th>Name</th><th>Salary</th></tr>
<%
  for(Employee emp:list){
	  %>
	  <tr>
	  <td><%= emp.getEmpNo() %></td>
	  <td><%= emp.getName() %></td>
	  <td><%= emp.getSalary() %></td>
	  </tr>
	  <% 
  }%>
  </table><br/>
  <%
if(list!=null && list.size()>0){
	for(int i=1;i<=noOfPages;i++){
		myURL="getEmployees?pageIndex="+i;
%>
<a href="<%=myURL%>"><%=i%></a>
<% 
	}
}
%>

</div>