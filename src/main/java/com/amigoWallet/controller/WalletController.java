package com.amigoWallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amigoWallet.dto.AddAmountRequest;
import com.amigoWallet.services.WalletService;

@RestController
@RequestMapping("/add")
public class WalletController {

	@Autowired
	private WalletService walletService;

	@PutMapping("/wallet/{id}")
	public String addAmount(@PathVariable Integer id, @RequestBody AddAmountRequest addAmountRequest) {
		walletService.addAmount(id, addAmountRequest);
		return "amount added";
	}

	@PutMapping("/wallet/{id}")
	public String addAmountToBank(@PathVariable Integer id, @RequestBody AddAmountRequest addAmountRequest) {
		walletService.addAmountToBank(id, addAmountRequest);
		return "amount added";
	}
}
