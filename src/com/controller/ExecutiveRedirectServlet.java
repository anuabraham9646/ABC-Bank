package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ExecutiveRedirectServlet")
public class ExecutiveRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ExecutiveRedirectServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd=null;
		String option=request.getParameter("CustomerDropdown");
		char m=option.charAt(1);
		
		switch(m){
		case '1':rd=request.getRequestDispatcher("Create_Customer.jsp");break;
		case '2':rd=request.getRequestDispatcher("UpdateCustomer.jsp");break;
		case '4':rd=request.getRequestDispatcher("CreateNewAccount.jsp");break;
		case '5':rd=request.getRequestDispatcher("Delete_Account.jsp");break;
		case '6':rd=request.getRequestDispatcher("View_Customer.jsp");break;
		case '7':rd=request.getRequestDispatcher("View_Account.jsp");break;
		}
		rd.forward(request, response);
	}

}
