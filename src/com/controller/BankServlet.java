package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.service.BankService;


@WebServlet("/BankServlet")
public class BankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 
       

    public BankServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Logger logger = Logger.getLogger(BankServlet.class);
		@SuppressWarnings("unused")
		PrintWriter out = response.getWriter();
		
		logger.debug("this is a debug log message");
        logger.info("this is a information log message");
        logger.warn("this is a warning log message");
		String action = request.getParameter("action");
		BankService service = new BankService();
		boolean found= false;
		String user_ID =request.getParameter("user_ID"),password = null;
		
		
		HttpSession session=request.getSession();
		session.setAttribute("user_ID",user_ID);
		if(action.equals("login")){
		
			
			password = request.getParameter("password");
		
		}
		found=service.loginUser(user_ID, password);
		if(found== true){
			if(user_ID.charAt(0)=='C'){
				session.setAttribute("Type",'C');
				RequestDispatcher rd=null;
				rd=request.getRequestDispatcher("Cashier.jsp");
			
				rd.forward(request, response);
			}
			else{
				session.setAttribute("Type",'E');
				RequestDispatcher rd=null;
				rd=request.getRequestDispatcher("CA_Exec.jsp");
			
				rd.forward(request, response);
			}
		
			
		}
		else if(found== false){
			
			RequestDispatcher rd=null;
			rd=request.getRequestDispatcher("Createfail.html");
		
			rd.forward(request, response);
		}
	
	}

}
