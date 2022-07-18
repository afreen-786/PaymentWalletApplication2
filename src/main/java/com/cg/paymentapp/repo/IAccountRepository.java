package com.cg.paymentapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.paymentapp.beans.BankAccount;
import com.cg.paymentapp.beans.Wallet;

@Repository
public interface IAccountRepository extends JpaRepository<BankAccount,Integer>{
	
	
}
