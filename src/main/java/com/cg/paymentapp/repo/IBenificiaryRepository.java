package com.cg.paymentapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.paymentapp.beans.BankAccount;
import com.cg.paymentapp.beans.BenificiaryDetails;
import com.cg.paymentapp.beans.Customer;

@Repository
public interface IBenificiaryRepository extends JpaRepository<BenificiaryDetails,Integer>{


	
}
