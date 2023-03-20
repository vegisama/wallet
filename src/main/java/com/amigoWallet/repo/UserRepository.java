package com.amigoWallet.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amigoWallet.entity.UserCredentials;

public interface UserRepository extends JpaRepository<UserCredentials, Integer>{

	Optional<UserCredentials> findByname(String username);

}
