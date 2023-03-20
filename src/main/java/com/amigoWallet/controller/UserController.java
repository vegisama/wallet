package com.amigoWallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amigoWallet.dto.AuthRequest;
import com.amigoWallet.entity.UserCredentials;
import com.amigoWallet.services.UserService;

@RestController
@RequestMapping("/auth")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationManager authManager;

	@PostMapping("/register")
	public String saveUser(@RequestBody UserCredentials user) {
		return userService.saveUser(user);
	}

	@PostMapping("/token")
	public String getToken(@RequestBody AuthRequest authRequest) {
		Authentication auth = authManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		if (auth.isAuthenticated()) {
			return userService.generateToken(authRequest.getUsername());
		} else {
			throw new RuntimeException("invalid access");
		}

	}

	@GetMapping("/validate")
	public String validateToken(@RequestParam("token") String token) {
		userService.validateToken(token);
		return "TOKEN IS VALID";
	}

}
