package com.cg.paymentapp.service;

import java.util.List;

import com.cg.paymentapp.beans.BenificiaryDetails;
import com.cg.paymentapp.beans.Customer;

public interface IBenificiaryService {

	public BenificiaryDetails addBenificiary(BenificiaryDetails bd) throws Exception;
	public BenificiaryDetails updateBenificiary(BenificiaryDetails bd) throws Exception;
	public BenificiaryDetails deleteBenificiary(BenificiaryDetails bd) throws Exception;
	public BenificiaryDetails viewBenificiary(int id)throws Exception;
	public List<BenificiaryDetails> viewAllBenificiary(Customer customer) throws Exception;
	
}
