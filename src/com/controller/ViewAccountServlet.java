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
import com.service.ViewAccountService;

@WebServlet("/ViewAccountServlet")
public class ViewAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ViewAccountServlet() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ViewAccountService vas=new ViewAccountService();
		ResultSet rs=vas.viewAccount();
		HttpSession session=request.getSession();
		session.setAttribute("result", rs);
		RequestDispatcher rd=null;
		rd=request.getRequestDispatcher("ViewAccountDetails.jsp");
		
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
