package com.amigoWallet.services;

import com.amigoWallet.dto.AddAmountRequest;

public interface WalletService {
	String addAmount(Integer id, AddAmountRequest addAmount);

	String addAmountToBank(Integer id,AddAmountRequest addAmount);
}
