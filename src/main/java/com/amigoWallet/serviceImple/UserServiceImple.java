package com.amigoWallet.serviceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.amigoWallet.entity.BillDetails;
import com.amigoWallet.entity.UserCredentials;
import com.amigoWallet.entity.WalletDetails;
import com.amigoWallet.repo.BillDetailsRepository;
import com.amigoWallet.repo.UserRepository;
import com.amigoWallet.repo.WalletRepository;
import com.amigoWallet.services.UserService;

@Service
public class UserServiceImple implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private WalletRepository walletRepo;

	@Autowired
	private BillDetailsRepository billRepository;

	@Autowired
	private WalletDetails walletDet;

	@Autowired
	private BillDetails billDetails;

	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private JwtService jwtService;

	@Override
	public String saveUser(UserCredentials user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepo.save(user);
		walletDet.setId(user.getId());
		billDetails.setId(user.getId());
		walletRepo.save(walletDet);
		billRepository.save(billDetails);
		return "account created successfully";
	}
	
	public String generateToken(String username) {
		return jwtService.generateToken(username);
	}

	public void validateToken(String token) {
		jwtService.validateToken(token);
	}

}
