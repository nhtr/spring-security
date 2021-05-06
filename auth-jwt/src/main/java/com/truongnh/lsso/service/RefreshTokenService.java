package com.truongnh.lsso.service;

import com.truongnh.lsso.persistence.entity.RefreshToken;

public interface RefreshTokenService {
	RefreshToken generateRefreshToken();
	void validateRefreshToken(String token);
	public void deleteRefreshToken(String token);
}
