package org.jsp.CDA.email;

public class Helper {
	public static int getOTP() {
		double otp=0;
		while(otp<1000) {
			otp=Math.random()*10000;
		}
		return (int)otp;
	}

}
