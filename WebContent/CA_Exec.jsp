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
  <%
	if(session.getAttribute("user_ID") == null){
	    //session.removeAttribute("user_ID");
	    response.sendRedirect("Login.html");
	    //System.out.println("hello");
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
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar2">
    <span class="navbar-toggler-icon"></span>
  </button>
  
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
    
    <h5>&nbsp;&nbsp;&nbsp;&nbsp;Welcome <%=session.getAttribute("user_ID") %></h5>
    <br><br>
    
      <div class="dropdown dropright" style="margin-left:50px">
    	<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
     	 Select the task
   		 </button>
   		 <div class="dropdown-menu dropdown-menu-right">
    		  <a class="dropdown-item" href="Create_Customer.jsp">Create Customer</a>
     		  <a class="dropdown-item" href="UpdateCustomer.jsp">Update Customer/Delete Customer</a>
     		  <a class="dropdown-item" href="CreateNewAccount.jsp">Create Account</a>
     		  <a class="dropdown-item" href="Delete_Account.jsp">Delete Account</a>
     		  <a class="dropdown-item" href="Bank.jsp">Customer Information</a>
     		  <a class="dropdown-item" href="ViewCustomerServlet">View Customer</a>
     		  <a class="dropdown-item" href="ViewAccountServlet">View Account Status</a>
   		 </div>
  	  </div>

      <hr class="d-sm-none">
    </div>
  </div>
</div>

<div class="footer">
<p>Copyright@HJA16GroupB</p>
</div>

</body>
</html>