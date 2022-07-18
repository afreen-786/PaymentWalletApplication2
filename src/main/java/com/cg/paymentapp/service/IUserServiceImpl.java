package com.cg.paymentapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.repo.IUserRepo;

@Service("IUserService")
public class IUserServiceImpl implements IUserService{
	
	@Autowired
	IUserRepo iUserRepo;

	@Override
	public String validateLogin(String mobileNumber, String password) throws Exception {
		Customer bean = null;
		try {
			for(Customer i : iUserRepo.findAll()) {
				if(i.getMobileNo().equals(mobileNumber)) {
					if(i.getPassword().equals(password)) {
						return "Authentication Successfull";
					}
					return "User details not found! Invalid details";
				}
			}
		}
		catch(Exception e) {
			throw new Exception("User details not found! Invalid details");
		}
		return "Authentication Successfull";
	}

}
