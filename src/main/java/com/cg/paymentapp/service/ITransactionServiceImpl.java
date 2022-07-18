package com.cg.paymentapp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.paymentapp.beans.Transaction;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.repo.ITransactionRepository;

@Service("ITransactionService")
public class ITransactionServiceImpl implements ITransactionService{
	
	@Autowired
	ITransactionRepository iTransactionRepository;

	@Override
	public Transaction addTransaction(Transaction tran) throws Exception {
		iTransactionRepository.saveAndFlush(tran);
		return tran;
	}

	@Override
	public List<Transaction> viewAllTransactions(Wallet wallet) throws Exception {
		return wallet.getTranscations();
	}

	@Override
	public List<Transaction> viewTransactionsByDate(LocalDate from, LocalDate to) throws Exception {
		List<Transaction> ans = new ArrayList<Transaction>();
		try {
			for(Transaction i : iTransactionRepository.findAll()) {
				if(from.isAfter(i.getTransactionDate()) && to.isBefore(i.getTransactionDate())) {
					ans.add(i);
				}
			}
		}
		catch(Exception e) {
			throw new Exception("Transcation details not found");
		}
		return ans;
	}

	@Override
	public List<Transaction> viewAllTransactions(String type) throws Exception {
		List<Transaction> ans = new ArrayList<Transaction>();
		try {
			for(Transaction i : iTransactionRepository.findAll()) {
				if(i.getTransactionType().equals(type)) {
					ans.add(i);
				}
			}
		}
		catch(Exception e) {
			throw new Exception("Transcation details not found");
		}
		return ans;
	}

}
