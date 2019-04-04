package com.service;

import java.util.ArrayList;
import com.DAO.AccStatementDAO;
import com.bean.GroupB_Transaction;


public class AccStatementService {
AccStatementDAO td = new AccStatementDAO();
	
	public ArrayList<GroupB_Transaction> getStatement(String aid, int n) {
		return td.getStatement(aid, n);
	}
}
