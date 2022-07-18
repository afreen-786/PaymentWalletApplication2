package com.cg.paymentapp.service;

import java.util.List;

import com.cg.paymentapp.beans.BankAccount;
import com.cg.paymentapp.beans.Wallet;

public interface IAccountService {

	public BankAccount addAccount(BankAccount bacc) throws Exception;
	public BankAccount removeAccount(int id) throws Exception;
	public BankAccount viewAccount(int id) throws Exception;
	public List<BankAccount> viewAllAccounts(Wallet wallet) throws Exception;
	
	
}
