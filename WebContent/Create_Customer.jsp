<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>

  <%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");

%>
<%
	if(session.getAttribute("user_ID") == null){
	    response.sendRedirect("Login.html");}%>
<style>
body {
    background-color: lightblue;
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

<script type="text/javascript">
function val(){
	var x= 0;
	var a= document.getElementById("ssn_ID").value;
	if(a.length<9){
		alert("ID too short");
		return false;
	}
	else{
		x++;
	}
	var b =document.getElementById("age").value;
	var numbers = /^[0-9]+$/;
    if(b.match(numbers))
    {
    	x++;
    }
    else{
    	alert("Age Should be Numeric");
    }
    if(x==2){
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
</head>
<%
if(session.getAttribute("user_ID") == null){
    //session.removeAttribute("user_ID");
    response.sendRedirect("Login.html");
 
}

%>
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

<div class="container" style="margin-top:60px; margin-bottom:100px;  min-height:400px">
  <div class="row menu">
    <div class="col-sm-12">

<div align="center">
<form action="CreateCustomer" method = "post" ng-app="myApp" ng-controller="validateCtrl" 
name="myForm" novalidate onsubmit="return val()">

<h2><center><i><b> Customer Form</b> </i></center></h2>
<br>

<p color="red" bgcolor="white">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="teal "><b><font color="red"><b>*<b></b></font> MARKED FIELDS ARE MANDATORY

</b></font><table>

<tr>
<td>SSN ID:</td>
<td><input type = "text" id= "ssn_ID" name = "ssn_ID" ng-model="ssn_ID" required> <span ng-show="myForm.ssn_ID.$error.required"><font color="red"><b>*<b></b></font></span></td>
</tr>


<tr>
<td>Customer Name:</td>
<td><input type = "text" name = "name" ng-model="name" required>  <span ng-show="myForm.name.$error.required"><font color="red"><b>*<b></b></font></span></td>
</tr>

<tr>
<td>Age:</td>
<td><input type = "text" id="age" name = "age" ng-model="age" required>  <span ng-show="myForm.age.$error.required"><font color="red"><b>*<b></b></font></span></td>
</tr>

<tr>
<td>Address Line1:</td>
<td><input type = "text" name = "address1" ng-model="address1" required> <span ng-show="myForm.address1.$error.required"><font color="red"><b>*<b></b></font></span> </td>
</tr>

<tr>
<td>Address Line2:</td>
<td><input type = "text" name = "address2"></td>
</tr>

<tr>
<td>City:</td>
<td><input type = "text" name = "city" ng-model="city" required>  <span ng-show="myForm.city.$error.required"><font color="red"><b>*<b></b></font></span></td>
</tr>

<tr>
<td>State</td>
<td><input type = "text" name = "state" ng-model="state" required>  <span ng-show="myForm.state.$error.required"><font color="red"><b>*<b></b></font></span></td>
</tr>

</table>
<br><br>
<center>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" class="btn btn-info btn-md" ng-disabled="myForm.ssn_ID.$pristine ||myForm.name.$pristine || myForm.age.$pristine || myForm.address1.$pristine || myForm.city$pristine ||myForm.state.$pristine ">
          <span class="glyphicon glyphicon-fire"></span> Submit
        </button>
</center>
</form>

</div>


 <hr class="d-sm-none">
    </div>
  </div>
</div>

<div class="footer">
<p>Copyright@HJA16GroupB</p>
</div>


<script>
var app = angular.module('myApp', []);
app.controller('validateCtrl', function($scope) {
$scope.ssn_ID;
$scope.name;
$scope.age;
$scope.city;
$scope.state;
$scope.address1;

//$scope.email;
});
</script>
</body>
</html>