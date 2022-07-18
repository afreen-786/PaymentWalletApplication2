package com.cg.paymentapp.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/*
 
 
{
	"ifscCode" : "68989899389",
	"bankName" : "SBI",
	"balance" : "1000"
}
 
 */

@Entity
public class BankAccount {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountNo;
	private String ifscCode;
	private String bankName;
	private double balance;

	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "wallet_id", referencedColumnName = "walletId")
	private Wallet wallet;
	
	@OneToMany(mappedBy = "bankAccount" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Transaction> transcations;
	
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "customer_id", referencedColumnName = "customerId")
	private Customer customer;

	public BankAccount() {
		super();
	}

	public BankAccount(int accountNo, String ifscCode, String bankName, double balance, Wallet wallet,
			List<Transaction> transcations, Customer customer) {
		super();
		this.accountNo = accountNo;
		this.ifscCode = ifscCode;
		this.bankName = bankName;
		this.balance = balance;
		this.wallet = wallet;
		this.transcations = transcations;
		this.customer = customer;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public List<Transaction> getTranscations() {
		return transcations;
	}

	public void setTranscations(List<Transaction> transcations) {
		this.transcations = transcations;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	
}
