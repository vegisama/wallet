package com.amigoWallet.serviceImple;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.amigoWallet.config.CustomUserDetails;
import com.amigoWallet.repo.UserRepository;

public class CustomerUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userCredentialRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<com.amigoWallet.entity.UserCredentials> credentails = userCredentialRepository.findByname(username);
		return credentails.map(CustomUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("user not found with ur name"));
	}

}
