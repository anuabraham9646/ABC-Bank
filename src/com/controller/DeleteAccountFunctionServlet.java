package com.controller;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.service.DeleteAccountService;

@WebServlet("/DeleteAccountFunctionServlet")
public class DeleteAccountFunctionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public DeleteAccountFunctionServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		DeleteAccountService das=new DeleteAccountService();
			RequestDispatcher rd=null;
			String idx=request.getParameter("fetchid");
			int a=das.deleteAccount(idx);
			
			
			
		if(a==1){
			response.sendRedirect("Allsucc.jsp");}
			else{
				response.sendRedirect("Allerror.jsp");
			}
	}

}
