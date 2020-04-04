package com.hanxiaocu.jwt.security.model.token;

import com.hanxiaocu.jwt.security.exceptions.ExpiredTokenException;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;

/**
 * @desc: 原始token  未签名
 * @author: hanchenghai
 * @date: 2018/11/14 5:16 PM
 */
@Slf4j
public class RawAccessToken implements Token {

	private String token;

	public RawAccessToken(String token) {
		this.token = token;
	}

	/**
	 * 分析并且验证Token是否有效
	 *
	 * @throws BadCredentialsException 如果验证请求被拒绝，则因为凭据无效 <br> 对于要抛出的异常，它意味着该帐户既不锁定也不禁用。 <br>
	 * @throws ExpiredTokenException   过期的Token
	 */
	public Jws<Claims> parseClaims(String signingKey) {
		try {
			return Jwts.parser().setSigningKey(signingKey).parseClaimsJws(this.token);
		} catch (UnsupportedJwtException | MalformedJwtException | IllegalArgumentException | SignatureException ex) {
			log.error("Invalid Token", ex);
			throw new BadCredentialsException("Invalid token: ", ex);
		} catch (ExpiredJwtException expiredEx) {
			log.info("Token is expired", expiredEx);
			throw new ExpiredTokenException(this, "Token expired", expiredEx);
		}
	}

	@Override
	public String getToken() {
		return token;
	}
}
