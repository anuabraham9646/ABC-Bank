package com.service;

import com.DAO.CreateAccount;
import com.util.DBTransaction;

public class CreateAccountService {
	public boolean createAccount(DBTransaction db,String CID,String sa_ca,double DA)
	{
		return CreateAccount.createAccount(db, CID, sa_ca, DA);
	}
}
