package com.amigoWallet.serviceImple;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigoWallet.entity.TransactionDetails;
import com.amigoWallet.repo.TransactionRepository;
import com.amigoWallet.services.TransactionService;

@Service
public class TransactionServiceImple implements TransactionService{
	
	@Autowired
	private TransactionRepository transactionRepo;
	
	@Override
	public TransactionDetails getTransactionsById(Integer id) {
		Optional<TransactionDetails> tId = transactionRepo.findById(id);
		if(tId.isPresent()) {
			return transactionRepo.getReferenceById(id);
		}
		return null;
	}

}
