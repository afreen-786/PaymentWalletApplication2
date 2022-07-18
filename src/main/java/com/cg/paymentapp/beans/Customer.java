package com.cg.paymentapp.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/*
 
 {
	"name" : "Kunal Sharma",
	"mobileNo" : "90908890890",
	"password" : "kunal@123"
}
  
 */

@Entity
public class Customer {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String name;
	private String mobileNo;
	private String password;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "wallet_id", referencedColumnName = "walletId")
	private Wallet wallet;
	
	@OneToMany(mappedBy = "customer" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<BankAccount> bankAccounts;

	public Customer() {
		super();
	}

	public Customer(int customerId, String name, String mobileNo, String password, Wallet wallet,
			List<BankAccount> bankAccounts) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.mobileNo = mobileNo;
		this.password = password;
		this.wallet = wallet;
		this.bankAccounts = bankAccounts;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}
	
	
	
	
	
}


