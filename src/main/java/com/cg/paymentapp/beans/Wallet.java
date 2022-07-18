package com.cg.paymentapp.beans;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
/*
  {
 "walletId" : "20001",
 "balance" : "2000",
 "bankAccounts" : "SBI",
 }
 */
@Entity
public class Wallet {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int walletId;
	private Double balance;
	
	@OneToMany(mappedBy = "wallet" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<BankAccount> bankAccounts;
	
	@OneToMany(mappedBy = "wallet" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Transaction> transcations;
	
	@OneToMany(mappedBy = "wallet" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<BillPayment> billPayments;
	
	@OneToMany(mappedBy = "wallet" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<BenificiaryDetails> benificiaryDetails;

	public Wallet() {
		super();
	}

	public Wallet(int walletId, Double balance, List<BankAccount> bankAccounts, List<Transaction> transcations,
			List<BillPayment> billPayments, List<BenificiaryDetails> benificiaryDetails) {
		super();
		this.walletId = walletId;
		this.balance = balance;
		this.bankAccounts = bankAccounts;
		this.transcations = transcations;
		this.billPayments = billPayments;
		this.benificiaryDetails = benificiaryDetails;
	}

	public int getWalletId() {
		return walletId;
	}

	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	public List<Transaction> getTranscations() {
		return transcations;
	}

	public void setTranscations(List<Transaction> transcations) {
		this.transcations = transcations;
	}

	public List<BillPayment> getBillPayments() {
		return billPayments;
	}

	public void setBillPayments(List<BillPayment> billPayments) {
		this.billPayments = billPayments;
	}

	public List<BenificiaryDetails> getBenificiaryDetails() {
		return benificiaryDetails;
	}

	public void setBenificiaryDetails(List<BenificiaryDetails> benificiaryDetails) {
		this.benificiaryDetails = benificiaryDetails;
	}
	
	
}
