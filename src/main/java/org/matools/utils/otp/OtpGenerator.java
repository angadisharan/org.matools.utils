package org.matools.utils.otp;

import java.security.SecureRandom;

public class OtpGenerator {

    private static final SecureRandom secureRandom = new SecureRandom();

    public static String generateOtp(int length, Boolean excludeZeroGenerationAtFirstDigit) {
        if (length <= 0) {
            throw new IllegalArgumentException("OTP length must be greater than 0");
        }
        StringBuilder otp = new StringBuilder(length);

        if (excludeZeroGenerationAtFirstDigit) {
            int firstDigit = secureRandom.nextInt(1, 9); // 0-9
            otp.append(firstDigit);
            if (length > 1) {
                otp.append(generateOtp(length - 1));
            }
        } else {
            otp.append(generateOtp(length));
        }

        return otp.toString();
    }



    public static String generateOtp(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("OTP length must be greater than 0");
        }

        StringBuilder otp = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int digit = secureRandom.nextInt(10); // 0-9
            otp.append(digit);
        }

        return otp.toString();
    }

    public static void main(String[] args) {
        System.out.println(generateOtp(6)); // Example: 483920
    }
}