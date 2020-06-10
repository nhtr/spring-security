package com.truongnh.lsso.service;

import com.truongnh.lsso.model.AuthenticationResponse;
import com.truongnh.lsso.model.LoginRequest;
import com.truongnh.lsso.model.RefreshTokenRequest;
import com.truongnh.lsso.model.RegisterRequest;
import com.truongnh.lsso.persistence.entity.User;
import com.truongnh.lsso.persistence.entity.VerificationToken;

public interface AuthService {
	void signup(RegisterRequest registerRequest);
	
	User getCurrentUser();
	
	void fetchUserAndEnable(VerificationToken verificationToken);
	
	String generateVerificationToken(User user);
	
	void verifyAccount(String token);
	
	AuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
	
	AuthenticationResponse login(LoginRequest loginRequest);
}
