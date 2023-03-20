package com.amigoWallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amigoWallet.entity.BankAccountDetails;
import com.amigoWallet.services.BankAccountService;

@RestController
@RequestMapping("/account")
public class BankAccountController {

	@Autowired
	private BankAccountService bankAccountService;

	@PostMapping("/registration")
	public String saveBankDetails(@RequestBody BankAccountDetails accountDetails) {
		bankAccountService.saveBankAccount(accountDetails);
		return "account details saved";
	}
}
