package com.cg.paymentapp.service;
import java.math.BigDecimal;
import java.util.List;

import com.cg.paymentapp.beans.BankAccount;
import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.beans.Wallet;


public interface WalletService {
	
	public Customer createAccount(BankAccount acc) throws Exception;
	public Customer showBalance (String mobileno) throws Exception;
	public Customer fundTransfer (String sourceMobileNo,String targetMobileNo, double amount) throws Exception;
	public Customer depositAmount (String mobileNo,double amount ) throws Exception;
	public Customer withdrawAmount(String mobileNo, double amount) throws Exception;
	public List<Customer> getList() throws Exception;
	public Customer updateAccount(Customer customer) throws Exception;
	public Wallet addMoney(Wallet wallet, double amount) throws Exception;

}
