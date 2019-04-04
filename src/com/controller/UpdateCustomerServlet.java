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

import com.service.BankService;
import com.service.UpdateCustomerService;

@WebServlet("/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UpdateCustomerServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		UpdateCustomerService service = new UpdateCustomerService();
		ResultSet user;
		String customer_ID1 = null;
		customer_ID1 = request.getParameter("customer_ID");
		if(action.equals("search")){
		
			
			user=service.searchCustomer(customer_ID1);
		
			HttpSession session=request.getSession();
			session.setAttribute("result", user);
			RequestDispatcher rd=null;
			rd=request.getRequestDispatcher("fetchcustomer.jsp");
		
			rd.forward(request, response);
		}
		else if(action.equals("Update")){
			int updated= 0;
			String customer_ID = request.getParameter("customer_ID");
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String address1 = request.getParameter("address1");
			String address2 = request.getParameter("address2");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			
			
			updated=service.updateCustomer(customer_ID,name, age, address1, address2, city, state);
			if(updated==1){
				response.sendRedirect("Allsucc.jsp");
				
			}
			else{
				response.sendRedirect("Allerror.jsp");
			}
			
		}
		else if(action.equals("Delete")){
			int deleted= 0;
			String customer_ID = request.getParameter("customer_ID");
			deleted=service.deleteCustomer(customer_ID);
			if(deleted==1){
				response.sendRedirect("Allsucc.jsp");
				
			}
			else{
				response.sendRedirect("Allerror.jsp");
			}
			
		}
		
	}

}
