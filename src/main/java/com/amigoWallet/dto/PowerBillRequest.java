package com.amigoWallet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PowerBillRequest {

	private String powerBill;

	private String PaymentType;
	
	private Long accountNumber;

}
