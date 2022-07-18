package com.cg.paymentapp.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.beans.Transaction;
import com.cg.paymentapp.beans.Wallet;

@Repository
public interface WalletRepo  extends JpaRepository<Wallet,Integer>{

}
