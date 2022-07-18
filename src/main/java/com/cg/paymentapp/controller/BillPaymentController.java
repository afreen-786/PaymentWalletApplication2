package com.cg.paymentapp.controller;

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
import com.cg.paymentapp.beans.BillPayment;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.service.IAccountService;
import com.cg.paymentapp.service.IBillPaymentService;


@RestController
@RequestMapping("/pwa-payment")
public class BillPaymentController {
	
	@Autowired
	IBillPaymentService iBillPaymentService;
	
	@PostMapping("/addBillPayment")
	public BillPayment addBillPayment(@RequestBody BillPayment payment) throws Exception{
		return iBillPaymentService.addBillPayment(payment);
	}
	
	@GetMapping("/viewBillPayment/{id}")
	public BillPayment viewBillPayment(@PathVariable int id) throws Exception{
		return iBillPaymentService.viewBillPayment(id);
	}

}
