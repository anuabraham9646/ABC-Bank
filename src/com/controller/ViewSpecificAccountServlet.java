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

@WebServlet("/ViewSpecificAccountServlet")
public class ViewSpecificAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ViewSpecificAccountServlet() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("search")){ 
			
			String id = request.getParameter("user_ID");
				System.out.println(id);
				ViewSpecificAccountService service = new ViewSpecificAccountService();
				ResultSet account;
				
				account=service.viewSpecificAccount(id);
				
				HttpSession session=request.getSession();
				session.setAttribute("result", account);
				System.out.println(session+"servlet");
				RequestDispatcher rd=null;
				rd=request.getRequestDispatcher("fetchaccount.jsp");
				rd.forward(request, response);
		}
	}

}
