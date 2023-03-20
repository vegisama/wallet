package com.amigoWallet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/trasactions")
@RestController
public class TransactionController {
	
	
	@GetMapping("/{id}")
	public String getTransactions(@PathVariable Integer id) {
		
		return "got transactions";
		
	}
}
