package com.cg.paymentapp.service;

import com.cg.paymentapp.beans.Customer;

public interface IUserService {

	public String validateLogin(String mobileNumber,String password) throws Exception;
}
