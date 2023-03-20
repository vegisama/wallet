package com.amigoWallet.services;

import com.amigoWallet.dto.PowerBillRequest;

public interface BillService {
	String powerBillPayment(Integer id,PowerBillRequest powerBill);
}
