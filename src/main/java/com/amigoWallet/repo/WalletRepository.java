package com.amigoWallet.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amigoWallet.entity.WalletDetails;

public interface WalletRepository extends JpaRepository<WalletDetails, Integer>{

}
