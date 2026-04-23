package org.matools.utils.hash;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public final class HashUtil {

    private static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder(10);
    private static final PasswordEncoder OTP_ENCODER = new BCryptPasswordEncoder(8);

    private HashUtil() {}

    public static String hash(String raw, HashType type) {
        validate(raw);

        return getEncoder(type).encode(raw);
    }

    public static boolean matches(String raw, String hash, HashType type) {
        if (raw == null || hash == null) return false;

        return getEncoder(type).matches(raw, hash);
    }

    private static PasswordEncoder getEncoder(HashType type) {
        return switch (type) {
            case PASSWORD -> PASSWORD_ENCODER;
            case OTP -> OTP_ENCODER;
        };
    }

    private static void validate(String raw) {
        if (raw == null || raw.isBlank()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
    }
}