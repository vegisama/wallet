package com.amigoWallet.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountDetails {
	
	
	@Id
	private Long accountNumber;
	
	private String Holdername;
	
	@Column(length=4)
	private Integer pin;
	
	private Double balance;
}
