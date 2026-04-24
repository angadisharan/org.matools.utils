package org.matools.utils.token;

import java.security.SecureRandom;
import java.util.Base64;

public final class TokenUtils {

    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64Encoder =
            Base64.getUrlEncoder().withoutPadding();

    private TokenUtils() {}

    public static String generateRefreshToken() {
        byte[] randomBytes = new byte[32]; // 256-bit
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }
}