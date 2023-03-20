package com.amigoWallet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddAmountRequest {

	private Double amount;

	private Long accountNumber;
	
	private String type;

	private Integer pin;
	

}
