package com.cg.paymentapp.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.paymentapp.beans.Transaction;
import com.cg.paymentapp.beans.Wallet;

public interface ITransactionService {

	public Transaction addTransaction (Transaction tran) throws Exception;
	public List<Transaction> viewAllTransactions (Wallet wallet) throws Exception;
	public List<Transaction> viewTransactionsByDate(LocalDate from,LocalDate to) throws Exception;
	public List<Transaction> viewAllTransactions(String type) throws Exception;
}
