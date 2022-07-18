package com.cg.paymentapp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.paymentapp.service.IUserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.paymentapp.beans.BankAccount;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.service.IAccountService;


@RestController
@RequestMapping("/pwa-user")
public class UserController {
	
	@Autowired
	IUserService iUserService;
	
	@GetMapping("/validateLogin/{mobileNumber}/{password}")
	public String validateLogin(@PathVariable String mobileNumber,@PathVariable String password) throws Exception{
		return iUserService.validateLogin(mobileNumber, password);
	}

}
