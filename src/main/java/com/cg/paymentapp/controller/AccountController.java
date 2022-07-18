package com.cg.paymentapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


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
@RequestMapping("/pwa-account")
public class AccountController {
	
	@Autowired 
	IAccountService iAccountService;
	
	@PostMapping("/addAccount")
	public BankAccount addAccount(@RequestBody BankAccount bacc) throws Exception{
		return iAccountService.addAccount(bacc);
	}
	
	@DeleteMapping("/removeAccount/{id}")
	public BankAccount removeAccount(@PathVariable int id) throws Exception{
		return iAccountService.removeAccount(id);
	}
	
	@GetMapping("/viewAccount/{id}")
	public BankAccount viewAccount(@PathVariable int id) throws Exception{
		return iAccountService.viewAccount(id);
	}
	
	@GetMapping("/viewAllAccounts")
	public List<BankAccount> viewAllAccounts(@PathVariable Wallet wallet) throws Exception{
		return iAccountService.viewAllAccounts(wallet);
	}

}
