<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	if(session.getAttribute("user_ID") == null){
	    response.sendRedirect("Login.html");}%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
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