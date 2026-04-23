package org.matools.utils.otp;

import java.security.SecureRandom;

public final class OtpGenerator {

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    private OtpGenerator() {
        // prevent instantiation
    }

    public static String generateOtp(int length, boolean excludeZeroAtFirstDigit) {
        if (length <= 0) {
            throw new IllegalArgumentException("OTP length must be greater than 0");
        }

        StringBuilder otp = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int digit;

            if (i == 0 && excludeZeroAtFirstDigit) {
                digit = SECURE_RANDOM.nextInt(1, 10); // 1–9
            } else {
                digit = SECURE_RANDOM.nextInt(10); // 0–9
            }

            otp.append(digit);
        }

        return otp.toString();
    }

    public static String generateOtp(int length) {
        return generateOtp(length, false);
    }

    public static void main(String[] args) {
        System.out.println(generateOtp(6));       // e.g. 483920
        System.out.println(generateOtp(6, true)); // no leading zero
    }
}