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
<script type="text/javascript">
function validate(){
	
	var a =document.getElementById("DA").value;
	var numbers = /^[0-9]+$/;
    if(a.match(numbers))
    {
    	var b = document.getElementById("CID").value;
    	if(b.charAt(0)=='U'){

    		 return true;
    	
    	 }
    	else{
    		alert("Not valid account");
    		return false;
    	}
    }
    else
    {
    alert('Please input numeric characters only');
    return false;
    }
	
}	
</script>
<%
if(session.getAttribute("user_ID") == null){
    response.sendRedirect("Login.html");
    System.out.println("hello");
}
%>
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
  .inp{
  	 width: 300px;
  clear: both;
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

<div class="container" style="margin-top:100px; min-height:400px">
  <div class="row menu">
    <div class="col-sm-12">
<form action="CreateNewAccountServlet"  method="post" ng-app="myApp" ng-controller="validateCtrl" 
name="myForm" novalidate onsubmit="return validate()">

<h1><center><i><strong>Create Account</strong></i></center></h1>
<br><br>
<div class="inp" >
<b>CUSTOMER ID:</b> <span ng-show="myForm.CID.$error.required"><font color="tomato"><b>*<b></b></font></span>
<td><input class="inp" id="CID" type = "text" name = "CID" ng-model="CID" required></td>
</tr>
<br>
<tr>
<br>
<td>ACCOUNT TYPE:</td>

</tr>

<td><select name="sa_ca" class="inp" >
<option value="sa">Savings Account</option>
<option value="ca">Current Account</option>

</select><br>
</td> 
<br>
<tr> <br><td>DEPOSIT AMOUNT:</td> <span ng-show="myForm.DA.$error.required"><font color="tomato"><b>*<b></b></font></span>
<td><input class="inp"  id="DA" type = "text" name = "DA" ng-model="DA" required> </td>
</tr>
<br>
</div>
<tr>
<tr> 

<br>
 <button type="submit" value = "Submit" ng-disabled="myForm.CID.$pristine ||myForm.DA.$pristine" class="btn btn-default btn-md">
          <span class="glyphicon glyphicon-fire"></span> Submit
        </button>
</tr>
</form>

 <hr class="d-sm-none">
    </div>
  </div>
</div>

<div class="footer">
<p>Copyright@HJA16GroupB</p>
</div>

</body>
<script>
var app = angular.module('myApp', []);
app.controller('validateCtrl', function($scope) {
$scope.CID;
$scope.DA;

//$scope.email;
});
</script>
</html>