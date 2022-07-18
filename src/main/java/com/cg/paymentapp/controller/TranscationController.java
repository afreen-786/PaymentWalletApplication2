package com.cg.paymentapp.controller;

import java.time.LocalDate;
import java.util.List;

import com.cg.paymentapp.beans.Transaction;
import com.cg.paymentapp.beans.Wallet;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.paymentapp.beans.BankAccount;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.service.IAccountService;
import com.cg.paymentapp.service.ITransactionService;


@RestController
@RequestMapping("/pwa-transcation")
public class TranscationController {
	
	@Autowired
	ITransactionService iTransactionService;
	
	@PostMapping("/addTransaction")
	public Transaction addTransaction (@RequestBody Transaction tran) throws Exception{
		return iTransactionService.addTransaction(tran);
	}
	
	@GetMapping("/viewAllTransactions")
	public List<Transaction> viewAllTransactions (@RequestBody Wallet wallet) throws Exception{
		return iTransactionService.viewAllTransactions(wallet);
	}
	
	@GetMapping("/viewTransactionsByDate/{from}/{to}")	
	public List<Transaction> viewTransactionsByDate(@RequestParam("localDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from, 
			@RequestParam("localDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) throws Exception{
		return iTransactionService.viewTransactionsByDate(from, to);
	}
	
	@GetMapping("/viewAllTransactions/{type}")	
	public List<Transaction> viewAllTransactions(@PathVariable String type) throws Exception{
		return iTransactionService.viewAllTransactions(type);
	}

}
