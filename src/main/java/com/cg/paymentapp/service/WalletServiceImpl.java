package com.cg.paymentapp.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.paymentapp.beans.BankAccount;
import com.cg.paymentapp.beans.BenificiaryDetails;
import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.beans.Transaction;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.repo.IAccountRepository;
import com.cg.paymentapp.repo.IUserRepo;
import com.cg.paymentapp.repo.WalletRepo;

@Service("WalletService")
public class WalletServiceImpl implements WalletService{
	
	@Autowired
	WalletRepo walletRepo;
	
	@Autowired
	IAccountRepository iAccountRepository;
	
	@Autowired
	IUserRepo iUserRepo;

	@Override
	public Customer createAccount(BankAccount acc) throws Exception {
		iAccountRepository.saveAndFlush(acc);
		return acc.getCustomer();
	}

	@Override
	public Customer showBalance(String mobileno) throws Exception {
		try {
			for(Customer i : iUserRepo.findAll()) {
				if(i.getMobileNo().equals(mobileno)) {
					return i;
				}
			}
		}
		catch(Exception e) {
			throw new Exception("Customer details not found");
		}
		return null;
	}

	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, double amount) throws Exception {
		Customer  sender = null;
		Customer  reciever = null;
		try {
			for(Customer i : iUserRepo.findAll()) {
				if(i.getMobileNo().equals(sourceMobileNo)) {
					sender = i;
				}
				else if(i.getMobileNo().equals(targetMobileNo)) {
					reciever = i;
				}
			}
		}
		catch(Exception e) {
			throw new Exception("Customer details not found");
		}
		sender.getWallet().setBalance(sender.getWallet().getBalance()-amount);
		reciever.getWallet().setBalance(reciever.getWallet().getBalance()+amount);
		return sender;
	}

	@Override
	public Customer depositAmount(String mobileNo, double amount) throws Exception {
		Customer  reciever = null;
		try {
			for(Customer i : iUserRepo.findAll()) {
				if(i.getMobileNo().equals(mobileNo)) {
					reciever = i;
				}
			}
		}
		catch(Exception e) {
			throw new Exception("Customer details not found");
		}
		reciever.getWallet().setBalance(reciever.getWallet().getBalance()+amount);
		return reciever;
	}

	@Override
	public Customer withdrawAmount(String mobileNo, double amount) throws Exception {
		Customer  reciever = null;
		try {
			for(Customer i : iUserRepo.findAll()) {
				if(i.getMobileNo().equals(mobileNo)) {
					reciever = i;
				}
			}
		}
		catch(Exception e) {
			throw new Exception("Customer details not found");
		}
		reciever.getWallet().setBalance(reciever.getWallet().getBalance()-amount);
		return reciever;
	}

	@Override
	public List<Customer> getList() throws Exception {
		return iUserRepo.findAll();
	}

	@Override
	public Customer updateAccount(Customer customer) throws Exception {
		Customer  bean = null;
		try {
			bean = iUserRepo.findById(customer.getCustomerId()).get();
		}
		catch(Exception e) {
			throw new Exception("Customer details not found!");
		}
		iUserRepo.saveAndFlush(customer);
		return customer;
	}

	@Override
	public Wallet addMoney(Wallet wallet, double amount) throws Exception {
		Wallet  bean = null;
		try {
			bean = walletRepo.findById(wallet.getWalletId()).get();
		}
		catch(Exception e) {
			throw new Exception("Wallet details not found!");
		}
		wallet.setBalance(wallet.getBalance()+amount);
		return wallet;
	}

}
