package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CashierRedirect")
public class CashierRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public CashierRedirect() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=null;
		String option=request.getParameter("CustomerDropdown");
		char m=option.charAt(1);
		
		switch(m){
		case '1':rd=request.getRequestDispatcher("ViewSpecificAccount.jsp");break;
		case '2':rd=request.getRequestDispatcher("AccStatement1.jsp");break;
		}
		rd.forward(request, response);
	}

}
