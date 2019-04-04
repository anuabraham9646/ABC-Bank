<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Error Page</title>
</head>
<%
	if(session.getAttribute("user_ID") == null){
	    response.sendRedirect("Login.html");}%>
<body>

<% if(session.getAttribute("Type").equals('C')){
	%>
	<%response.sendRedirect("Cashier.jsp");
	
	
	 %>

<%}
else if(session.getAttribute("Type").equals('E')) {
	response.sendRedirect("CA_Exec.jsp");
	
	%>

<%}%>
</body>
</html>