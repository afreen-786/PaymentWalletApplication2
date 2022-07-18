package com.cg.paymentapp.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BenificiaryDetails {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int benificiaryId;
	private String name;
	private String mobileNumber;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "wallet_id", referencedColumnName = "walletId")
	private Wallet wallet;

	public BenificiaryDetails() {
		super();
	}

	public BenificiaryDetails(int benificiaryId, String name, String mobileNumber, Wallet wallet) {
		super();
		this.benificiaryId = benificiaryId;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.wallet = wallet;
	}

	public int getBenificiaryId() {
		return benificiaryId;
	}

	public void setBenificiaryId(int benificiaryId) {
		this.benificiaryId = benificiaryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	
	

	
}
