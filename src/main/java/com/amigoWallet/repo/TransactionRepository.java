package com.amigoWallet.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amigoWallet.entity.TransactionDetails;

public interface TransactionRepository extends JpaRepository<TransactionDetails, Integer>{

}
