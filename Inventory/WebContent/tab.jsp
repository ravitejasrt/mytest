<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<%@ page import="com.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>

<body>
<%!
  List<String> list=null;
%>
<%
  DBUtility dbu=new DBUtility();
  try{
   Connection conn=dbu.getConnection();
   System.out.println("conn = "+conn);
   Statement stm=conn.createStatement();
   String sql="select *  from Catergory ";
   ResultSet rs=stm.executeQuery(sql);
   list=new ArrayList<String>();
   while(rs.next()){
	  String CATERGORYID=rs.getString("CATERGORYID");
	  String CATNAME=rs.getString("CATNAME");
	  list.add(CATNAME);
   }
  }
  catch(Exception e){
	  e.printStackTrace();
  }
%>
<script>
/* $(document).ready(function(){

$('#submit').click(function(evt) {
   alert("working");
   $("home").hide();
   $("update").hide();
   $("report").hide();
   alert("working");

});
});
 */
 
 $(function() {

 $("#menu1_form").submit(function(e) {

    //prevent Default functionality
    e.preventDefault();

    //get the action-url of the form
    var actionurl = e.currentTarget.action;

    //do your own request an handle the results
    $.ajax({
            url: actionurl,
            type: 'get',
            dataType: 'text',
            data: $("#menu1_form").serialize(),
            success: function(data) {
               alert("hi");
               $("#result").html("Succefully connected");
            }
    });

});
 });
</script>
<script>
$(function() {

	 $("#menu2_form1").submit(function(e) {

	    //prevent Default functionality
	    e.preventDefault();

	    //get the action-url of the form
	    var actionurl = e.currentTarget.action;

	    //do your own request an handle the results
	    $.ajax({
	            url: actionurl,
	            type: 'get',
	            dataType: 'text',
	            data: $("#menu2_form1").serialize(),
	            success: function(data) {
	               alert("hi");
	               $("#result2").html("Succefully connected");
	            }
	    });

	});
	 $("#catgeid").change(function(){
		 alert("changed");
		 var catgeid=$("#catgeid").val();
		 alert("catgeid  =  "+catgeid);
		 $.ajax({
	            url: "ActionServlet?catgeid="+catgeid,
	            type: 'get',
	            dataType: 'text',
	            data: $("#menu3_form1").serialize(),
	            success: function(data) {
	               alert("hi");
	               alert(data)
	               $("#result3").html("Succefully connected");
	            }
	    });
	 });
	 });

</script>
<!-- <!-- <script type="text/javascript">
$(document).ready(function() {
    $('body').on('click', '.my-button', function() {

    });
});
</script>
<script type="text/javascript">
$('a').click(function(event) {
    switch(this.id) {
        case 'test1':
            alert('link with an id of test1!');
            event.preventDefault();
            break;
        case 'test2':
            alert('link with an id of test2!');
            event.preventDefault();
            break;
        default:
            //Default behavior
    }
});
</script> --> -->
<div class="container">
  <h2>Dynamic Tabs</h2>
  <ul class="nav nav-tabs">
<!--     <li class="active"><a data-toggle="tab" id="home" href="#home">Home</a></li>
 -->    <li><a data-toggle="tab" href="#menu1" id="profile">Menu 1</a></li>
    <li><a data-toggle="tab" href="#menu2" id="update">Menu 2</a></li>
    <li><a data-toggle="tab" href="#menu3" id="report">Menu 3</a></li>
  </ul>
  
      <%
         String catid=(String)request.getAttribute("catid");
         String prodid=(String)request.getAttribute("prodid");   
         out.println("prodid = "+prodid);
         out.println("catid = "+catid);
      %>
  <div class="tab-content">
    <!-- <div id="home" class="tab-pane fade in active">
      <h3>HOME</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
    </div>
     -->
    <div id="menu1" class="tab-pane">
      <h3>Menu 1</h3>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
     <form action="./ActionServlet" id="menu1_form"> 
      <select  id="catid"name="catid">
       <%for(int i=0;i<list.size();i++){ %> 
        <option><%=list.get(i)%></option>
        <%}%>
      </select>
      Product <input type="text" id="prodid" name="prodid"/>
      <input type="submit" id="submit" name="submit"/>
      <p id="result"></p>
     </form> 
           <%="sucessfully inserted"%>
     <%out.println("ygyugyugbuhjb==========================") ;%>
     

    </div>
    <div id="menu2" class="tab-pane fade">
      <h3>Menu 2</h3>
      <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
     <form action="./ActionServlet" id="menu2_form1"> 
        check menu2 <input id="menu2text" type="text" name="menu2text"/>
        <input id="submit" type="submit" name="submit"/>
     </form>
      <p id="result"></p>

    </div>
    <div id="menu3" class="tab-pane fade">
      <h3>Menu 3</h3>
      <p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
      <form id="menu3_form1">
        <select id="catgeid" name="catgeid">
           <option>Select Category</option>
           <option>Mobile</option>
           <option>Laptop</option>
        </select>
        <select id="prodid" name="prodid">
           <option>Select Product</option>
        </select>
        Qty: <input type="text" id="qty" name="qty"/>     
        Price: <input type="text" id="price" name="qty"/>      
        <input type="submit" name="menu3sub" id="menu3sub"/>
      </form>
      <div id="result3"></div>
    </div>
  </div>
</div>

</body>
</html>

