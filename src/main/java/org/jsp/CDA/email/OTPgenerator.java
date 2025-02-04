package org.jsp.CDA.email;

import java.security.SecureRandom;

public class OTPgenerator {
	public static String generateOTP(int length) {
		SecureRandom random=new SecureRandom();
		 StringBuilder otp = new StringBuilder();

	        for (int i = 0; i < length; i++) {
	            otp.append(random.nextInt(10));
	        }
	        return otp.toString();
	}
	

}
