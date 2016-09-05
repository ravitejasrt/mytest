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

    <h1>index2</h1>
    <div class="indextab">
  <style>
	.demo select {
		border: 0 !important;  /*Removes border*/
		-webkit-appearance: none;  /*Removes default chrome and safari style*/
		-moz-appearance: none; /* Removes Default Firefox style*/
        appearance:none;
		background: #0088cc url(img/select-arrow.png) no-repeat 90% center;
		width: 100px; /*Width of select dropdown to give space for arrow image*/
		text-indent: 0.01px; /* Removes default arrow from firefox*/
		text-overflow: "";  /*Removes default arrow from firefox*/ /*My custom style for fonts*/
		color: #FFF;
		border-radius: 15px;
		padding: 5px;
		box-shadow: inset 0 0 5px rgba(000,000,000, 0.5);
	}
	.demo select.balck {
		background-color: #000;
	}
	.demo select.option3 {
		border-radius: 10px 0;
	}
</style>
<script>
 $(function(){
    $("#catid").change(function(){
      var catid=$("#catid").val();
 //     alert("catid = "+catid);
      $.ajax({
    	 url:"AdminServlet",
    	 type:"get",
    	 data:{catid:catid},
    	 success : function(response){
    		$("#seloption3").html(response);
    	 }
      });
    }); 
    $("#pricedet").blur(function(){
      var price=$("#pricedet").val();
	  var reg=/^[0-9]+$/;  			
		if(price.length=="" || price.length<2){
	            $("#pricetext").css("color","red");
			    $("#pricetext").text("Names with more than 2 letters!");
				return false;
		}
		 if(price.length>2){	
			if(!(reg.test(price))){
		        $("#pricetext").css("color","red");			
				$("#pricetext").text("Use only Numbers");
				return false;
			}
		}  
		if(true){
		//	alert("success");
			$("#pricetext").css("color","green");		
				$("#pricetext").text("");					
				return true;
		}       
    });
    $("#qtydet").blur(function(){
    	var qty=$("#qtydet").val();
   // 	alert("qty = "+qty);
    	var reg=/^[0-9]+$/;
    	if(qty.length==""){
    	//	alert("price.length==0");
    		$("#qtytxt").css("color","red");
    		$("#qtytxt").text("Use only Numbers");
    	}
		if(qty.length>1){	
		  if(!(reg.test(qty))){
	 //   	alert("!(reg.test(qty)");
			 $("#qtytxt").css("color","red");			
			 $("#qtytxt").text("Use only Numbers");
			 return false;
		  }
		}      	
		if(true){
	//		alert("success");
            $("#qtytxt").css("color","green");		
			$("#qtytxt").text("");					
			return true;
	    }  		
 //       $("#focusqty").css("color","green");
 //   	$("#focusqty").html("sucessfully updated "+qty);    
    }); 
	$("#submitadmn").submit(function (e){
	   e.preventDefault();
       var catid=$("#catid").val();
       var productid=$("#seloption3").val();
       var pricedet=$("#pricedet").val();
       var qtydet=$("#qtydet").val();
       if(catid.length==0){
    	   alert("price");
           $("#catidtxt").css("color","red");
           $("#catidtxt").text("select");
           return false;    	   
       }
       if(productid.length==0){
           $("#prodidtext").css("color","red");
           $("#prodidtext").text("select");
           return false;
       } 
       if(pricedet.length==0){
    	   alert("price");
           $("#pricetxt").css("color","red");
           $("#pricetxt").text("Use only Numbers");
           return false;    	   
       }
       if(qtydet.length==0){
           $("#qtytxt").css("color","red");
           $("#qtytxt").text("Use only Numbers");
           return false;
       }       
       //       alert(catid+" = "+productid+" = "+pricedet+" = "+qtydet);
		 $.ajax({
	            url: "AdminServlet?catid="+catid+"&productid="+productid+"&pricedet="+pricedet+"&qtydet="+qtydet,
	            type: 'get',
	            dataType: 'text',
	//            data: $("#submitadmn").serialize(),
	            success: function(data) {
	               alert("hi");
	               alert(data)
	               $("#submittxt").css("color","green");
	               $("#submittxt").html(data);
	            }
	    });       
	});
	$("#addproductform").submit(function (e){
		e.preventDefault();
		var catidnp=$("#catidnp").val();
		var addproduct=$("#addproduct").val();
		if(addproduct.length==0){
		  $("#addproducttxt").css("color","red");	
		  $("#addproducttxt").text("Please enter only numbers");
		  return false;
		}
		alert("catidnp = "+catidnp+" addproduct = "+addproduct);
		$.ajax({
			url:"AdminServlet",
			type:"get",
			dataType:"text",
			data:{addproduct:addproduct,catidnp:catidnp},
			success : function(data){
			  $("#addprsubtxt").css("color","green");
		      $("#addprsubtxt").html(data);
			}
		});
	});
 });
</script>

<%
   AdminDao admindao=new AdminDao();
   List<Admin> adminlst=admindao.getCatgorys();
//action="./AdminServlet"
%>
  <form class="demo" id="submitadmn" >
	Category : <select id="catid" name="catid">
	 <option>select Category</option>
	 <%for(int i=0;i<adminlst.size();i++){ %>
		<option value=<%=adminlst.get(i).getCATERGORYID()%> ><%=adminlst.get(i).getCATERGORYNAME()%></option>
	 <%} %>
	</select>
	<div id="catidtxt"></div>
	<br><br>
    Products : <select class="balck" id="seloption3" name="seloption3">
	</select>
	<div id="prodidtxt"></div>
	<br><br>
   Price :<input type="text" id="pricedet" name="pricedet"/>
	<br><br>
   <div id="pricetext"></div>

   Qty :<input type="text" id="qtydet" name="qtydet"/>
   <div id="qtytxt"></div>
	<br><br>
  <input type="submit" id="submit" name="submit"/>	
     <div id="submittxt"></div>
  
<!-- 	<select class="option3">
		<option>CSS</option>
		<option>HTML </option>
		<option>HTML 5</option>
	</select> -->
</form>

<form class="demo" id="addproductform">
  Category : <select id="catidnp" name="catidnp">
	 <option>select Category</option>
	 <%for(int i=0;i<adminlst.size();i++){ %>
		<option value=<%=adminlst.get(i).getCATERGORYID()%> ><%=adminlst.get(i).getCATERGORYNAME()%></option>
	 <%} %>
	</select>
  <br><br>
  Add Product<input type="text" id="addproduct" name="addproduct">	
  <div id="addproducttxt"></div>
  <br><br>
  <input id="submitap" name="submitap" value="submit" type="submit"/>
  <div id="addprsubtxt"></div>
</form>

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