package com.truongnh.lsso.security;

import static io.jsonwebtoken.Jwts.parser;
import static java.util.Date.from;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.sql.Date;
import java.time.Instant;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.truongnh.lsso.exception.SpringLssoException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JwtProvider {

	private KeyStore keyStore;

	@Value("${jwt.expiration.time}")
	private Long jwtExpireTime;

	@PostConstruct
	public void init() {
		try {
			keyStore = KeyStore.getInstance("JKS");
			InputStream resourceAsStream = getClass().getResourceAsStream("/springlsso.jks");
			keyStore.load(resourceAsStream, "truong00".toCharArray());
		} catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException e) {
			log.error("Exception occurred while loading keystore", e);
		}
	}

	public String generateToken(Authentication authentication) {
		User principal = (User) authentication.getPrincipal();
		return Jwts.builder().setSubject(principal.getUsername()).setIssuedAt(from(Instant.now()))
				.signWith(getPrivateKey()).setExpiration(Date.from(Instant.now().plusMillis(jwtExpireTime)))
				.compact();
	}

	public String generateTokenWithUserName(String username) {
		return Jwts.builder().setSubject(username).setIssuedAt(from(Instant.now())).signWith(getPrivateKey())
				.setExpiration(Date.from(Instant.now().plusMillis(jwtExpireTime))).compact();
	}

	private PrivateKey getPrivateKey() {
		try {
			return (PrivateKey) keyStore.getKey("lsso", "truong00".toCharArray());
		} catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e) {
			throw new SpringLssoException("Exception occured while retrieving public key from keystore");
		}
	}

	public boolean validateToken(String jwt) {
		parser().setSigningKey(getPublickey()).parseClaimsJws(jwt);
		return true;
	}

	private PublicKey getPublickey() {
		try {
			return keyStore.getCertificate("lsso").getPublicKey();
		} catch (KeyStoreException e) {
			throw new SpringLssoException("Exception occured while " + "retrieving public key from keystore");
		}
	}

	public String getUsernameFromJwt(String token) {
		Claims claims = parser().setSigningKey(getPublickey()).parseClaimsJws(token).getBody();

		return claims.getSubject();
	}

	public Long getJwtExpirationInMillis() {
		return jwtExpireTime;
	}
}
