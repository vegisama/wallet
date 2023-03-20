package com.amigoWallet.serviceImple;

import java.math.BigInteger;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigoWallet.dto.AddAmountRequest;
import com.amigoWallet.entity.BankAccountDetails;
import com.amigoWallet.entity.TransactionDetails;
import com.amigoWallet.entity.WalletDetails;
import com.amigoWallet.repo.BankAccountRepository;
import com.amigoWallet.repo.TransactionRepository;
import com.amigoWallet.repo.WalletRepository;
import com.amigoWallet.services.WalletService;

@Service
public class WalletServiceImple implements WalletService {

	@Autowired
	private WalletRepository walletRepo;

	@Autowired
	private BankAccountRepository bankRepo;

	@Autowired
	private TransactionRepository TransactionRepo;

	@Autowired
	private TransactionDetails transacionDetails;

	String generateUUIDNo = String.format("%010d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16));
	String unique_no = generateUUIDNo.substring(generateUUIDNo.length() - 10);

	@Override
	public String addAmount(Integer id, AddAmountRequest addAmount) {
		Optional<BankAccountDetails> accountNo = bankRepo.findById(addAmount.getAccountNumber());
		Optional<WalletDetails> walletId = walletRepo.findById(id);
		if (accountNo.isPresent()) {
			if (bankRepo.getReferenceById(addAmount.getAccountNumber()).getPin().equals(addAmount.getPin())) {
				if (bankRepo.getReferenceById(addAmount.getAccountNumber()).getBalance() >= addAmount.getAmount()) {
					walletRepo.getReferenceById(id)
							.setAmount(walletRepo.getReferenceById(id).getAmount() + addAmount.getAmount());
					bankRepo.getReferenceById(addAmount.getAccountNumber()).setBalance(bankRepo.getReferenceById(addAmount.getAccountNumber()).getBalance()-addAmount.getAmount());
					transacionDetails.setId(unique_no);
					transacionDetails.setTransactionType(generateUUIDNo);
					transacionDetails.setAmount(addAmount.getAmount());
					return "Amount added";
				}
			}
		}
		return "Amount not added";
	}

	@Override
	public String addAmountToBank(Integer id, AddAmountRequest addAmount) {

		Optional<BankAccountDetails> accountNo = bankRepo.findById(addAmount.getAccountNumber());
		Optional<WalletDetails> walletId = walletRepo.findById(id);
		if (accountNo.isPresent()) {
			if (bankRepo.getReferenceById(addAmount.getAccountNumber()).getPin().equals(addAmount.getPin())) {
				if (bankRepo.getReferenceById(addAmount.getAccountNumber()).getBalance() >= addAmount.getAmount()) {
					bankRepo.getReferenceById(addAmount.getAccountNumber())
							.setBalance(walletRepo.getReferenceById(id).getAmount() + addAmount.getAmount());
					walletRepo.getReferenceById(id).setAmount(walletRepo.getReferenceById(id).getAmount()-addAmount.getAmount());
					transacionDetails.setId(unique_no);
					transacionDetails.setTransactionType(generateUUIDNo);
					transacionDetails.setAmount(addAmount.getAmount());
					return "Amount added";
				}
			}
		}
		return "Amount not added";

	}

}
