<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");

%>
<%
if(session.getAttribute("user_ID") == null){
    //session.removeAttribute("user_ID");
    response.sendRedirect("Login.html");
    System.out.println("hello");
}%>
 <meta http-equiv="refresh" content="30">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background = "d3.jpg">

<form action="ExecutiveRedirectServlet" method = "post">

<h1><center><i><strong><font color="red">Customer Account Executive</font></strong></i></center></h1>

<br>
<td>
<select name="CustomerDropdown">
<option value="v0"><i>Select the task</i></option>
<option value="v1">Create Customer</option>
<option value="v2">Update Customer/Delete Customer</option>
<option value="v4">Create Account</option>
<option value="v5">Delete Account</option>
<option value="v6">View Customer</option>
<option value="v7">View Account Status</option>

</select>
</td>
</br>

<tr><center><h3><input type = "submit" value = "Submit"></h3></center></tr>

</form>
<br><br>
<form action="Logout" method="get">
<input type = "submit" value = "Logout">
</form>
<br><br><br><br><br><br><br><br><br>

<footer>
<p><h6>Copyright@HJA16GroupB</h6></p>
</footer>



</body>
</html>