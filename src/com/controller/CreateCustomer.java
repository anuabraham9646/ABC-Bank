package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.service.CreateCustomerService;

@WebServlet("/CreateCustomer")
public class CreateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CreateCustomer() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger logger = Logger.getLogger(CreateCustomer.class);
		@SuppressWarnings("unused")
		PrintWriter out = response.getWriter();
		
		
	
		CreateCustomerService service = new CreateCustomerService();
		boolean found= false;
		
		String ssn_ID = request.getParameter("ssn_ID");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
			
	
		found=service.CreateUser(ssn_ID, name, age, address1, address2, city, state);
		if(found== true)
		{
			logger.debug("this is a debug log message");
	        logger.info("this is a information log message");
	        logger.warn("this is a warning log message");
	        response.sendRedirect("Successfulcreate.html");

		}
			
		else if(found== false)
		{
			logger.debug("this is a debug log message");
	        logger.info("this is a information log message");
	        logger.warn("this is a warning log message");
	        response.sendRedirect("FailureCreate.html");
			
		}

	}

}
