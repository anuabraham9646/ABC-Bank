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
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
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
<body background = "d3.jpg">

<div class="jumbotron text-center" style="margin-bottom:0">
  <h1>ABC Bank</h1>

</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <a class="navbar-brand" href="#">Cashier/Teller</a>
 <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar1,#collapsibleNavbar2">
    <span class="navbar-toggler-icon"></span>
  </button>
   <div class="collapse navbar-collapse" id="collapsibleNavbar1">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="Cashier.jsp">Home</a>
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
System.out.println("jsp "+ user);
%>
<table border="1" class="table table-bordered table-sm" align="left">
 <thead class="thead-dark">

<tr>
    <th>Account ID</th>
    <th>Customer ID</th>
    <th>Account Type</th>
    <th>Balance</th>
    <th>Status</th>
    <th>Action</th>
   
</tr>
</thead>
<%while(user.next()){ %>
<tbody class="table-light">
	<tr>
	<%System.out.println("fun "+ user.getString("Account_ID")); %>
	<td><%=user.getString("Account_ID")%></td>
	<td><%=user.getString("Customer_ID")%></td>
	<td><%=user.getString("Account_Type")%></td>
	<td><%=user.getInt("balance")%></td>
	<td><%=user.getString("status")%></td>
	
	
<td>
<form action="Withdraw_Amount.jsp" onsubmit="return validate()">
<input type="hidden" name= "id" value="<%=user.getString("Account_ID")%>">
<input type="hidden" id= "status" value="<%=user.getString("status")%>">

<button type="submit" id="withdraw" name="action" value="withdraw" class="btn btn-default btn-md">
          <span class="glyphicon glyphicon-upload"></span> Withdraw
        </button>
</form>


<form action="Transfercashier.jsp" onsubmit="return validate()">
<input type="hidden" name= "Account_ID" value="<%=user.getString("Account_ID")%>">
<input type="hidden" id= "status" value="<%=user.getString("status")%>">

<button type="submit" id="transfer" name="action" value="transfer" class="btn btn-default btn-md">
          <span class="glyphicon glyphicon-share"></span>Transfer
        </button>

</form>

<form action="deposit cashier.jsp" onsubmit="return validate()">
<input type="hidden" name= "Account_ID" value="<%=user.getString("Account_ID")%>">
<input type="hidden" id= "status" value="<%=user.getString("status")%>">
<button type="submit" id="deposit"  name="action" value="deposit" class="btn btn-default btn-md">
          <span class="glyphicon glyphicon-download"></span>Deposit
        </button>
</form>
</td>
<% }%></tr>
</tbody>
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