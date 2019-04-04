package com.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.ViewSpecificAccountService;
import com.service.ViewSpecificCustomerService;

@WebServlet("/ViewSpecificCustomerServlet")
public class ViewSpecificCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ViewSpecificCustomerServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ViewSpecificCustomerService vas= new ViewSpecificCustomerService();
		String action=request.getParameter("customer_ID");
		ResultSet rs= null;
		if(action.charAt(0)=='U'||action.charAt(0)=='C') {  
			
			
			String customer_ID=request.getParameter("customer_ID");
			rs=vas.searchCustomercust(customer_ID);
			
			
		}
		else{  
			String ssn_ID=(request.getParameter("customer_ID"));
			rs=vas.searchCustomerssn(ssn_ID);	
		}
		HttpSession session=request.getSession();
		session.setAttribute("result", rs);
		RequestDispatcher rd=null;
		rd=request.getRequestDispatcher("fetchspecficcustomer.jsp");
		rd.forward(request, response);

}
}
