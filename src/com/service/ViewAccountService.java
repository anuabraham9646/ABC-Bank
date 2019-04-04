package com.service;

import java.sql.ResultSet;
import com.DAO.ViewAccountDao;

public class ViewAccountService {

	public ResultSet viewAccount(){
		return ViewAccountDao.viewAccount();
	}
}
