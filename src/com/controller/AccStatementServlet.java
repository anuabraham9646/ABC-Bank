package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.AccStatementDAO;
import com.bean.GroupB_Transaction;
import com.service.AccStatementService;

@WebServlet("/AccStatementServlet")
public class AccStatementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AccStatementServlet() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String aid = request.getParameter("aid");
		
		int n = 0;
	    String sd = "";
        String ed = "";
        
        
        ArrayList<GroupB_Transaction> al = new ArrayList<GroupB_Transaction>();
        AccStatementDAO td = new AccStatementDAO();
       
		
		try {
			if(request.getParameter("n")==null){
				sd=request.getParameter("sd");
				
				ed=request.getParameter("ed");
				al = td.getStatements(aid, sd, ed);
	        }
			else if(request.getParameter("sd")==null||request.getParameter("ed")==null){
				n=Integer.parseInt(request.getParameter("n"));
				al = td.getStatement(aid,n);
			}
			
		 
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	
		HttpSession session=request.getSession();
		session.setAttribute("AccStatement", al);
		
		for (GroupB_Transaction g: al){
			System.out.println(g.getAccount_ID());
		}
		
		RequestDispatcher rd=null;
		rd=request.getRequestDispatcher("AccStatement.jsp");
		rd.forward(request, response);
	

	}
	}


