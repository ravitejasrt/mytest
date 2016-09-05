<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
p {
    font-family: sans-serif;
}

label.custom-select {
    position: relative;
    display: inline-block;
}

    .custom-select select {
        display: inline-block;
        border: 2px solid #bbb;
        padding: 4px 3px 3px 5px;
        margin: 0;
        font: inherit;
        outline:none; /* remove focus ring from Webkit */
        line-height: 1.2;
        background: #f8f8f8;
        
        -webkit-appearance:none; /* remove the strong OSX influence from Webkit */
        
        -webkit-border-radius: 6px;
        -moz-border-radius: 6px;
        border-radius: 6px;
    }

    /* for Webkit's CSS-only solution */
    @media screen and (-webkit-min-device-pixel-ratio:0) { 
        .custom-select select {
            padding-right:30px;    
        }
    }
    
    /* Since we removed the default focus styles, we have to add our own */
    .custom-select select:focus {
        -webkit-box-shadow: 0 0 3px 1px #c00;
        -moz-box-shadow: 0 0 3px 1px #c00;
        box-shadow: 0 0 3px 1px #c00;
    }
    
    /* Select arrow styling */
    .custom-select:after {
        content: "▼";
        position: absolute;
        top: 0;
        right: 0;
        bottom: 0;
        font-size: 60%;
        line-height: 30px;
        padding: 0 7px;
        background: #bbb;
        color: white;
        
        pointer-events:none;
        
        -webkit-border-radius: 0 6px 6px 0;
        -moz-border-radius: 0 6px 6px 0;
        border-radius: 0 6px 6px 0;
    }
    
    .no-pointer-events .custom-select:after {
        content: none;
    }
</style>
<body>
     <%@include file="index.jsp" %>
<div class="indextab">
<p><label class="custom-select">
    Select your favorite food:
    <select>
        <option>Sushi</option>
        <option>Blue cheese with crackers</option>
        <option>Steak</option>
        <option>Other</option>
    </select>
</label></p>
<p><strong>Note:</strong> Currently (Mar 4, 2011) only works in Webkit and Gecko</p>
<FORM>
<INPUT type="text" STYLE="color: #FFFFFF; font-family: Verdana; font-weight: bold; font-size: 12px; background-color: #72A4D2;" size="10" maxlength="30">
<input type='text' name='nofacture' STYLE='color=#FFFF00' size=6 maxlength=7>

</FORM>
</div>
</body>
<style>
div{
    background-color: lightgrey;
    width: 600px;
    border: 1px solid green;
    padding: 25px;
    margin: 25px;
}
</style>
</html>