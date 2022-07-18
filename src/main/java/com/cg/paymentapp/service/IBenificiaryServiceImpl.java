package com.cg.paymentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.paymentapp.beans.BankAccount;
import com.cg.paymentapp.beans.BenificiaryDetails;
import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.repo.IBenificiaryRepository;

@Service("IBenificiaryService")
public class IBenificiaryServiceImpl implements IBenificiaryService{
	
	@Autowired
	IBenificiaryRepository iBenificiaryRepository;

	@Override
	public BenificiaryDetails addBenificiary(BenificiaryDetails bd) throws Exception {
		iBenificiaryRepository.saveAndFlush(bd);
		return bd;
	}

	@Override
	public BenificiaryDetails updateBenificiary(BenificiaryDetails bd) throws Exception {
		BenificiaryDetails  bean = null;
		try {
			bean = iBenificiaryRepository.findById(bd.getBenificiaryId()).get();
		}
		catch(Exception e) {
			throw new Exception("Benificiary Detailsdetails not found!");
		}
		iBenificiaryRepository.saveAndFlush(bd);
		return bd;
	}

	@Override
	public BenificiaryDetails deleteBenificiary(BenificiaryDetails bd) throws Exception {
		BenificiaryDetails  bean = null;
		try {
			bean = iBenificiaryRepository.findById(bd.getBenificiaryId()).get();
		}
		catch(Exception e) {
			throw new Exception("Benificiary Details details not found!");
		}
		iBenificiaryRepository.deleteById(bd.getBenificiaryId());
		return bd;
	}

	@Override
	public BenificiaryDetails viewBenificiary(int id) throws Exception {
		BenificiaryDetails  bean = null;
		try {
			bean = iBenificiaryRepository.findById(id).get();
		}
		catch(Exception e) {
			throw new Exception("Benificiary Details details not found!");
		}
		return bean;
	}

	@Override
	public List<BenificiaryDetails> viewAllBenificiary(Customer customer) throws Exception {
		return customer.getWallet().getBenificiaryDetails();
	}

}
