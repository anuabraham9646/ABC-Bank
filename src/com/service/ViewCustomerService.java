package com.service;

import java.sql.ResultSet;
import com.DAO.ViewCustomerDao;

public class ViewCustomerService {

	public ResultSet viewCustomer()
	   {System.out.println("44");
      return ViewCustomerDao.viewCustomer();
	   }
}