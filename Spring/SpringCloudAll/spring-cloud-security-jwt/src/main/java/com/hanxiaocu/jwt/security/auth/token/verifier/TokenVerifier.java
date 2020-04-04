package com.hanxiaocu.jwt.security.auth.token.verifier;

/**
 * Token验证
 *
 * @author bbs
 * @since 2017-05-25
 */
public interface TokenVerifier {
    boolean verify(String jti);
}
