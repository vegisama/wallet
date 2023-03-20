package com.amigoWallet.services;

import com.amigoWallet.entity.TransactionDetails;

public interface TransactionService {
	TransactionDetails getTransactionsById(Integer id);
}
