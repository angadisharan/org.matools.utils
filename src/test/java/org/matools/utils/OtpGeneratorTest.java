package org.matools.utils;


import org.junit.jupiter.api.Test;
import org.matools.utils.otp.OtpGenerator;

import static org.junit.jupiter.api.Assertions.*;

class OtpGeneratorTest {

    @Test
    void shouldGenerateOtpOfGivenLength() {
        int length = 6;

        String otp = OtpGenerator.generateOtp(length);

        assertNotNull(otp);
        assertEquals(length, otp.length(), "OTP length mismatch");
    }

    @Test
    void shouldContainOnlyDigits() {
        String otp = OtpGenerator.generateOtp(6);

        assertTrue(otp.matches("\\d+"), "OTP should contain only digits");
    }

    @Test
    void shouldThrowExceptionForInvalidLength() {
        assertThrows(IllegalArgumentException.class,
                () -> OtpGenerator.generateOtp(0));
    }

    @Test
    void shouldNotStartWithZeroWhenExcluded() {
        String otp = OtpGenerator.generateOtp(6, true);

        assertNotNull(otp);
        assertEquals(6, otp.length());
        assertNotEquals('0', otp.charAt(0), "First digit should not be zero");
    }

    @Test
    void shouldAllowZeroWhenNotExcluded() {
        String otp = OtpGenerator.generateOtp(6, false);

        assertNotNull(otp);
        assertEquals(6, otp.length());
    }

    @Test
    void shouldGenerateDifferentOtps() {
        String otp1 = OtpGenerator.generateOtp(6);
        String otp2 = OtpGenerator.generateOtp(6);

        assertNotEquals(otp1, otp2, "OTPs should be random");
    }
}
