package com.amigoWallet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDetails {

	@Id
	private String id;

	private String TransactionType;

	private Double amount;

}
