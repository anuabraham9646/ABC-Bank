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
	    response.sendRedirect("Login.html");}%>
 <title>ABC Banking Website</title>
  <meta charset="utf-8">
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  <style>
  .footer {
min-height:50px;
padding: 15px 0;
width: 100%;
background-color: black;
color: white;
text-align: center;
}
  </style>
  
</head>
<body background="d3.jpg">

<div class="jumbotron text-center" style="margin-bottom:0">
  <h1>ABC Bank</h1>

</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <a class="navbar-brand" href="#">Customer Account Executive</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar1,#collapsibleNavbar2">
    <span class="navbar-toggler-icon"></span>
  </button>
   <div class="collapse navbar-collapse" id="collapsibleNavbar1">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="CA_Exec.jsp">Home</a>
      </li> 
    </ul>
  </div>  
  
  <div class="navbar-collapse collapse w-100 order-3 dual-collapse2" id="collapsibleNavbar2">
        <ul class="navbar-nav ml-auto">
           
            <li class="nav-item">
                <a class="nav-link" href="Logout">Logout</a>
            </li>
        </ul>
  </div>
</nav>

<div class="container" style="margin-top:100px; min-height:400px">
  <div class="row menu">
    <div class="col-sm-12">
    
<%@page import="java.util.*" %>
<%@page import="java.sql.*" %>

<%ResultSet user=(ResultSet)session.getAttribute("result");
//System.out.println("jsp"+ user);
user.next();
%>


<center><h2>Customer Details</h2></center>
<br><br>
<table border="1" class="table table-bordered table-sm" style="width:45%" align="center">
 <thead class="thead-dark" align="center">

<tr>
    <th style="width: 150px">SSN ID</th>
    <td style="width: 400px" class="table-light"><%=user.getString("ssn_ID")%></td>
    
    </tr>
    <tr>
    <th>Customer ID</th>
    <td class="table-light"><%=user.getString("Customer_ID")%></td>
    </tr>
    <tr>
    <th>Name</th>
    <td class="table-light"><%=user.getString("name")%></td>
    </tr>
    <tr>
    <th>Address</th>
    <td class="table-light"><%=user.getString("address1")%></td>
    </tr>
    <tr>
    <th>Age</th>
   <td class="table-light"><%=user.getInt("age")%></td>
   </tr>
</tr>
</thead>

</table>

 <hr class="d-sm-none">
    </div>
  </div>
</div>

<div class="footer">
<p>Copyright@HJA16GroupB</p>
</div>


</body>
</html>