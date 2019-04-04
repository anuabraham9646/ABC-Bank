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
import com.service.DeleteAccountService;


@WebServlet("/DeleteAccountServlet")
public class DeleteAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public DeleteAccountServlet() {
        super();

}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		ResultSet rs=null;
		DeleteAccountService das=new DeleteAccountService();
		String action = request.getParameter("action");
		System.out.println(action);
		String id=request.getParameter("id1");
			if(action.equalsIgnoreCase("view")){
				if(id.charAt(0)=='U'){
					rs=das.viewAccountID(id);
				}
					
				else{
						rs=das.viewAccountSSN(id);
						System.out.println(rs);
					}
				
						
				HttpSession session=request.getSession();
				session.setAttribute("result", rs);
				RequestDispatcher rd=null;
				rd=request.getRequestDispatcher("ViewDeleteAccount.jsp");
				rd.forward(request, response);	
			}
	 }
}
