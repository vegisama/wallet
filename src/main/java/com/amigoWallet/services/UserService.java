package com.amigoWallet.services;

import com.amigoWallet.entity.UserCredentials;

public interface UserService {
	String saveUser(UserCredentials user);
	String generateToken(String username);
	void validateToken(String token);
}
