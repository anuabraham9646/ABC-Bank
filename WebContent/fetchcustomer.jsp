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
<script type="text/javascript">

function myFunction(){
	document.getElementById("update").disabled = false;
}
function del(){
	var retVal = confirm("Do you want to Delete ?");
    if( retVal == true ){
       return true;
    }
    else{
    	return false;
    }
}
</script>
 <title>ABC Banking Website</title>
  <meta charset="utf-8">
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <style type="text/css">
  .inp {
  

    width: 80%;
}

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

<div class="container" style="margin-top:200px; min-height:400px">
  <div class="row menu">
    <div class="col-sm-12">
    
<%@page import="java.util.*" %>
<%@page import="java.sql.*" %>
<%ResultSet user=(ResultSet)session.getAttribute("result");

user.next();

%>
<form action="UpdateCustomerServlet" method="post"  ng-app="myApp" ng-controller="validateCtrl" 
name="myForm" novalidate>
<table border="1" class="table table-bordered table-sm" align="left">
 <thead class="thead-dark">
<tr>
    <th>customer_ID</th>
    <th>ssn_ID</th>
    <th>name</th>
    <th>age</th>
    <th>address1</th>
    <th>address2</th>
    <th>city</th>
    <th>state</th>
  
</tr>
</thead>
	
	<tr>
	<tbody class="table-light">
	<td><%=user.getString("customer_ID")%></input></td>
	<td><%=user.getString("ssn_ID")%></td>
	<td><input class="inp" type="text" id="name" name="name" ng-model="name"   value = "<%=user.getString("name")%>" onkeypress="myFunction()"></input></td>
	<td><input class="inp" type="text" id="age" name="age" ng-model="age"  value = "<%=user.getInt("age")%>" onkeypress="myFunction()"></td>
	<td><input class="inp" type="text" id="address1" ng-model="address1" name="address1"   value = "<%=user.getString("address1")%>" onkeypress="myFunction()"></td>
	<td><input class="inp" type="text" id="address2" ng-model="address2" name="address2"   value = "<%=user.getString("address2")%>" onkeypress="myFunction()"></td>
	<td><input class="inp" type="text" id="city" ng-model="city" name="city"   value = "<%=user.getString("city")%>" onkeypress="myFunction()"></td>
	<td><input class="inp" type="text" id="state" name="state" ng-model="state" value = "<%=user.getString("state")%>" onkeypress="myFunction()"></td>
	</tbody>
	</tr>
</table>
<input type="hidden" name="customer_ID" value="<%=user.getString("customer_ID")%>">

 <button type="submit" id="update" name="action" value="Update" disabled class="btn btn-default btn-md">
          <span class="glyphicon glyphicon-edit"></span> Update
        </button>


<button type="submit" id="delete" name="action" value="Delete" onclick="return del()" class="btn btn-default btn-md">
          <span class="glyphicon glyphicon-trash"></span> Delete 
        </button>
</form>
<%--response.sendRedirect("CustomerUpDelSuccess.html"); --%>

<hr class="d-sm-none">
    </div>
  </div>
</div>

<div class="footer">
<p>Copyright@HJA16GroupB</p>
</div>

</body>


</html>