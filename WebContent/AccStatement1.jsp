<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");

%>
<script type="text/javascript">
function validate(){
	var a = document.getElementById("id").value;
	if(a.charAt(0)=='S'||a.charAt(0)=='C'){
		if(a.length==8)
		 return true;
		else{
			alert("Invalid Account Number");
			return false;
		}
	
	 }
	
	else{
		alert("Invalid Account Number");
		 return false;
	 
	}
	return false;
}
</script>
<%
if(session.getAttribute("user_ID") == null){
    //session.removeAttribute("user_ID");
    response.sendRedirect("Login.html");
  
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
<body background="d3.jpg">
<script>
function check(){
	if(document.getElementById("no").checked==true){
		
		document.getElementById("nn").disabled=false;
		document.getElementById("sd").disabled=true;
		document.getElementById("sd").value="";
		document.getElementById("ed").disabled=true;
		document.getElementById("ed").value="";
	}
	
	else if(document.getElementById("trans").checked==true){
		
		document.getElementById("nn").disabled=true;
		document.getElementById("nn").value="";
		document.getElementById("sd").disabled=false;
		document.getElementById("ed").disabled=false;
	}
	
}

</script>

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
<center>
<h2>Transaction Details</h2>
<form action="AccStatementServlet" method="post" onsubmit="return validate()">
<b>Enter Account Number</b> <input type ="text" id="id" name="aid" required><br><br>
<input type="radio" name="no" id ="no" onclick="check()">
<b>No of Recent Transaction</b> <!--input type ="number" name="n" id ="nn" required -->
<select name="n" id="nn">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
<option value="7">7</option>
<option value="8">8</option>
<option value="9">9</option>
<option value="10">10</option>
</select>
<br><br>
<input type="radio" name="no" id ="trans" onclick="check()">
<b>Start Date</b> <input type="date" name="sd" id="sd" placeholder="YYYY-MM-DD" required>
<b>End Date </b><input type="date" name="ed" id="ed" placeholder="YYYY-MM-DD"required><br><br>

<button type="submit" value="View" class="btn btn-default btn-md">
          <span class="glyphicon glyphicon-eye-open"></span> View
        </button>
</form>
</center>
<hr class="d-sm-none">
    </div>
  </div>
</div>

<div class="footer">
<p>Copyright@HJA16GroupB</p>
</div>

</body>
</html>