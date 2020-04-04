package com.hanxiaocu.jwt.security.model.token;

import com.hanxiaocu.jwt.security.model.Scopes;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

import java.util.List;
import java.util.Optional;

/**
 * @desc: token刷新工具类
 * @author: hanchenghai
 * @date: 2018/11/14 5:15 PM
 */
public class RefreshToken implements Token{
	private Jws<Claims> claims;

	private RefreshToken(Jws<Claims> claims) {
		this.claims = claims;
	}

	public static Optional<RefreshToken> create(RawAccessToken token, String signingKey) {
		Jws<Claims> claims = token.parseClaims(signingKey);
		@SuppressWarnings("unchecked")
		List<String> scopes = claims.getBody().get("scopes", List.class);
		if (scopes == null || scopes.isEmpty()
				|| scopes.stream().noneMatch(scope -> Scopes.REFRESH_TOKEN.authority().equals(scope))
		) {
			return Optional.empty();
		}
		return Optional.of(new RefreshToken(claims));
	}

	@Override
	public String getToken() {
		return null;
	}


	public Jws<Claims> getClaims() {
		return claims;
	}

	public String getJti(){
		return claims.getBody().getId();
	}

	public String getSubject(){
		return claims.getBody().getSubject();
	}

}
