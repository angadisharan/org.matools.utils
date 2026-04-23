package org.matools.utils.hash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashUtilTest {

    @Test
    void shouldHashAndMatchPassword() {
        String raw = "MySecurePassword123";

        String hash = HashUtil.hash(raw, HashType.PASSWORD);

        assertNotNull(hash);
        assertTrue(HashUtil.matches(raw, hash, HashType.PASSWORD));
    }

    @Test
    void shouldHashAndMatchOtp() {
        String otp = "123456";

        String hash = HashUtil.hash(otp, HashType.OTP);

        assertNotNull(hash);
        assertTrue(HashUtil.matches(otp, hash, HashType.OTP));
    }

    @Test
    void shouldFailForIncorrectPassword() {
        String raw = "correctPassword";
        String wrong = "wrongPassword";

        String hash = HashUtil.hash(raw, HashType.PASSWORD);

        assertFalse(HashUtil.matches(wrong, hash, HashType.PASSWORD));
    }

    @Test
    void shouldFailForIncorrectOtp() {
        String otp = "123456";
        String wrongOtp = "654321";

        String hash = HashUtil.hash(otp, HashType.OTP);

        assertFalse(HashUtil.matches(wrongOtp, hash, HashType.OTP));
    }

    @Test
    void shouldGenerateDifferentHashesForSameInput() {
        String raw = "sameInput";

        String hash1 = HashUtil.hash(raw, HashType.PASSWORD);
        String hash2 = HashUtil.hash(raw, HashType.PASSWORD);

        assertNotEquals(hash1, hash2); // BCrypt salt check
    }

    @Test
    void shouldReturnFalseWhenRawIsNull() {
        String hash = HashUtil.hash("test", HashType.PASSWORD);

        assertFalse(HashUtil.matches(null, hash, HashType.PASSWORD));
    }

    @Test
    void shouldReturnFalseWhenHashIsNull() {
        assertFalse(HashUtil.matches("test", null, HashType.PASSWORD));
    }

    @Test
    void shouldThrowExceptionForBlankInput() {
        assertThrows(IllegalArgumentException.class,
                () -> HashUtil.hash("", HashType.PASSWORD));
    }

    @Test
    void shouldThrowExceptionForNullInput() {
        assertThrows(IllegalArgumentException.class,
                () -> HashUtil.hash(null, HashType.PASSWORD));
    }
}