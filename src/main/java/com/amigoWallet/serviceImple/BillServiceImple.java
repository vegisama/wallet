package com.amigoWallet.serviceImple;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigoWallet.dto.PowerBillRequest;
import com.amigoWallet.entity.BillDetails;
import com.amigoWallet.repo.BankAccountRepository;
import com.amigoWallet.repo.BillDetailsRepository;
import com.amigoWallet.repo.WalletRepository;
import com.amigoWallet.services.BillService;

@Service
public class BillServiceImple implements BillService {

	@Autowired
	private BillDetailsRepository billRepo;

	@Autowired
	private WalletRepository walletRepo;

	@Autowired
	private BankAccountRepository bankRepo;

	@Override
	public String powerBillPayment(Integer id, PowerBillRequest powerBill) {
		Optional<BillDetails> powerId = billRepo.findById(id);
		if (powerId.isPresent()) {
			if (powerBill.getPaymentType() == "Wallet") {
				if (billRepo.getReferenceById(id).getPowerBill() <= walletRepo.getReferenceById(id).getAmount()) {
					walletRepo.getReferenceById(id).setAmount(
							walletRepo.getReferenceById(id).getAmount() - billRepo.getReferenceById(id).getPowerBill());
					billRepo.getReferenceById(id).setPowerBill(0);
				} else {
					if (billRepo.getReferenceById(id).getPowerBill() <= bankRepo
							.getReferenceById(powerBill.getAccountNumber()).getBalance()) {
						bankRepo.getReferenceById(powerBill.getAccountNumber())
								.setBalance(bankRepo.getReferenceById(powerBill.getAccountNumber()).getBalance()
										- billRepo.getReferenceById(id).getPowerBill());
						billRepo.getReferenceById(id).setPowerBill(0);
					}
				}
			}
		}
		return null;

	}
}
