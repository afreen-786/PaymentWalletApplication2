package com.cg.paymentapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.beans.Transaction;

@Repository
public interface IUserRepo  extends JpaRepository<Customer,Integer>{

	
}
