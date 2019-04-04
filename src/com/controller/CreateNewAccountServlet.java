package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.CreateAccountService;
import com.util.DBTransaction;

@WebServlet("/CreateNewAccountServlet")
public class CreateNewAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public CreateNewAccountServlet() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean found= false;
		
		String CID=request.getParameter("CID");
		String sa_ca=request.getParameter("sa_ca");
		double DA=Double.parseDouble(request.getParameter("DA"));
		DBTransaction db=new DBTransaction();
		 CreateAccountService cas=new CreateAccountService();
		found=cas.createAccount(db,CID,sa_ca,DA);
		if(found== true){
			response.sendRedirect("Allsucc.jsp");
		}
		else{
			response.sendRedirect("Allerror.jsp");
		}
				
	}

}
