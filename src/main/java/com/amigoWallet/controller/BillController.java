package com.amigoWallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amigoWallet.dto.PowerBillRequest;
import com.amigoWallet.services.BillService;

@RestController
@RequestMapping("/bill")
public class BillController {
	
	@Autowired
	private BillService billService;
	
	@PutMapping("/power/{bill}")
	public String Powerbill(Integer id,PowerBillRequest powerBill) {
		billService.powerBillPayment(id, powerBill);
		return null;
		
	}
}
