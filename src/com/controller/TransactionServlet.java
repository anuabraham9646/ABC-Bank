package com.controller;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.TransactionService;


@WebServlet("/TransactionServlet")
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public TransactionServlet() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String action = request.getParameter("action");
		
		TransactionService ws = new TransactionService();
		
		
		
		
		if(action.equals("withdraw")){
			boolean check=false;
			String account_ID1=request.getParameter("Account_ID1");
			long amount = Long.parseLong(request.getParameter("withdrawl_Amount"));
		
			check= ws.withdraw_serv(account_ID1, amount);
			if(check){
				response.sendRedirect("Allsucc.jsp");
			}
			else
				response.sendRedirect("Allerror.jsp");
			
		}
		else if(action.equals("deposit")){
			boolean check=false;
			String account_ID1=request.getParameter("Account_ID1");
			long amount = Long.parseLong(request.getParameter("deposit_Amount"));
		
			check= ws.deposit_serv(account_ID1, amount);
			if(check){
				response.sendRedirect("Allsucc.jsp");
			}
			else
				response.sendRedirect("Allerror.jsp");
			
		}
		else if (action.equals("transfer")){
			boolean check=false;
			String account_ID1=request.getParameter("Account_ID1");
			long amount = Long.parseLong(request.getParameter("transfer_Amount"));
			String account_ID2=request.getParameter("Account_ID2");
			check= ws.transfer_serv(account_ID1,account_ID2, amount);
			if(check){
				response.sendRedirect("Allsucc.jsp");
			}
			else
				response.sendRedirect("Allerror.jsp");
			
		}
		}
}
