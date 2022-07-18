package com.cg.paymentapp.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.paymentapp.beans.BillPayment;
import com.cg.paymentapp.beans.Transaction;
import com.cg.paymentapp.beans.Wallet;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction,Integer>{
	
}
