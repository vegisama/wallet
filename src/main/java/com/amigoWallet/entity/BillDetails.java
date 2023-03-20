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
public class BillDetails {
	
	@Id
	private Integer id;

	private Integer powerBill;

	private Integer houseRent;
}
