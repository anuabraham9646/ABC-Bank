package com.service;

import java.sql.ResultSet;
import com.DAO.DeleteAccountDao;


public class DeleteAccountService {

	public ResultSet viewAccountID(String id)
	{
		return DeleteAccountDao.viewAccountID(id);
	}
	
	public ResultSet viewAccountSSN(String id)
		{
			return DeleteAccountDao.viewAccountSSN(id);
		}
	public int deleteAccount(String id)
	{
		return DeleteAccountDao.deleteAccount(id);
	}
}
