package com.amigoWallet.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amigoWallet.entity.BankAccountDetails;

public interface BankAccountRepository extends JpaRepository<BankAccountDetails, Long>{

}
