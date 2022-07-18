package com.cg.paymentapp.controller;

import java.util.List;

import com.cg.paymentapp.beans.BenificiaryDetails;
import com.cg.paymentapp.beans.Customer;

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
import com.cg.paymentapp.service.IBenificiaryService;


@RestController
@RequestMapping("/pwa-benificiary")
public class BenificiaryController {
	
	@Autowired
	IBenificiaryService iBenificiaryService;
	
	@PostMapping("/addBenificiary")
	public BenificiaryDetails addBenificiary(@RequestBody  BenificiaryDetails bd) throws Exception{
		return iBenificiaryService.addBenificiary(bd);
	}
	
	@PutMapping("/updateBenificiary")
	public BenificiaryDetails updateBenificiary(@RequestBody BenificiaryDetails bd) throws Exception{
		return iBenificiaryService.updateBenificiary(bd);
	}
	
	@DeleteMapping("/deleteBenificiary/{id}")
	public BenificiaryDetails deleteBenificiary(@RequestBody BenificiaryDetails bd) throws Exception{
		return iBenificiaryService.deleteBenificiary(bd);
	}
	
	@GetMapping("/viewBenificiary/{id}")
	public BenificiaryDetails viewBenificiary(@PathVariable int id)throws Exception{
		return iBenificiaryService.viewBenificiary(id);
	}
	
	@GetMapping("/viewAllBenificiary")
	public List<BenificiaryDetails> viewAllBenificiary(@RequestBody Customer customer) throws Exception{
		return iBenificiaryService.viewAllBenificiary(customer);
	}

}
