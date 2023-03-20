package com.amigoWallet.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amigoWallet.entity.BillDetails;

public interface BillDetailsRepository extends JpaRepository<BillDetails, Integer> {

}
