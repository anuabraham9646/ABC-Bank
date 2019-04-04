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

function validateForm(){
	var a = document.getElementById("user_ID").value;
	if(a.charAt(0)=='S'||a.charAt(0)=='C'){
	 if(a.length==8)
		 return true;
	 else {
		 alert("Not a valid Account ID");
		 return false;
	
	 }
	}
	else{
	 if(a.length==9)
		 return true;
	 else {		 alert("Not a valid SSN ID");
	 return false;
	 }
	 }
}

</script>
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


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%
if(session.getAttribute("user_ID") == null){ 
    response.sendRedirect("Login.html");
}%>

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



</head>

<body background="d3.jpg">

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

<form action="ViewSpecificAccountServlet" method="post" onsubmit="return validateForm()">


<center>
<b>SSN ID/ ACCOUNT ID<b></b><sup style="color:red"> *</sup>: <input type="text" id="user_ID" name="user_ID" ></input>
<input type="hidden" name= "action" value="search">

 <button type="submit" class="btn btn-default" id="i3" name="submit" value="search">
      <span class="glyphicon glyphicon-search"></span> Search
    </button>
</center>

</form>

<hr class="d-sm-none">
    </div>
  </div>
</div>

<div class="footer">
<p>Copyright@HJA16GroupB</p>
</div>

</body>
</html>