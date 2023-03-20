package com.amigoWallet.serviceImple;

import java.math.BigInteger;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigoWallet.entity.BankAccountDetails;
import com.amigoWallet.repo.BankAccountRepository;
import com.amigoWallet.services.BankAccountService;

@Service
public class BankAccountServiceImple implements BankAccountService {

	@Autowired
	private BankAccountRepository bankRepo;

	@Override
	public String saveBankAccount(BankAccountDetails accountDetails) {
		String generateUUIDNo = String.format("%010d",
				new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16));
		String unique_no = generateUUIDNo.substring(generateUUIDNo.length() - 10);
		accountDetails.setAccountNumber(Long.parseLong(unique_no));
		bankRepo.save(accountDetails);
		return "Account details saved";
	}

}
