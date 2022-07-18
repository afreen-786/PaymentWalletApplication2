package com.cg.paymentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.paymentapp.beans.BankAccount;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.repo.IAccountRepository;

@Service("IAccountService")
public class IAccountServiceImpl implements IAccountService{
	
	@Autowired
	IAccountRepository iAccountRepository;

	@Override
	public BankAccount addAccount(BankAccount bacc) throws Exception {
		iAccountRepository.saveAndFlush(bacc);
		return bacc;
	}

	@Override
	public BankAccount removeAccount(int id) throws Exception {
		BankAccount  bean = null;
		try {
			bean = iAccountRepository.findById(id).get();
		}
		catch(Exception e) {
			throw new Exception("Bank Account details not found!");
		}
		iAccountRepository.deleteById(id);
		return bean;
	}

	@Override
	public BankAccount viewAccount(int id) throws Exception {
		BankAccount  bean = null;
		try {
			bean = iAccountRepository.findById(id).get();
		}
		catch(Exception e) {
			throw new Exception("Bank Account details not found!");
		}
		return bean;
	}

	@Override
	public List<BankAccount> viewAllAccounts(Wallet wallet) throws Exception {
		return wallet.getBankAccounts();
	}

}
