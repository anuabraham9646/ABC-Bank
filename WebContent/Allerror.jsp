<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <%
	if(session.getAttribute("user_ID") == null){
	    //session.removeAttribute("user_ID");
	    response.sendRedirect("Login.html");
	    //System.out.println("hello");
	}
  %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="refresh" content="2;url=error.jsp" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body  background = "d3.jpg">
<br><br><br><br><br><br><br><br><br><br><br><br><br>
<% if(response.getStatus() == 500){ %>

<div class="container">
 <div class="alert alert-danger">
  <h4><center><strong><i>Error: <%=exception.getMessage() %></i></strong></center></h4>
 </div>
 </div>

<%}else {%>
<div class="container">
 <div class="alert alert-danger">
  <h4><center><strong><i>Hi There, error code is :<%=response.getStatus() %></i></strong></center></h4>
 </div>
 </div>
<br>
<%} %>
</body>
</html>