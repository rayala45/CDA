package org.jsp.CDA.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {
	@Autowired
	JavaMailSender jms;
	
	@Value("${spring.mail.username}")
	private String usermail;
	
	public void sendMail(String receipient,String body,String subject) {
		SimpleMailMessage smm=new SimpleMailMessage();
		smm.setFrom(usermail);
		smm.setTo(receipient);
		smm.setText(body);
		smm.setSubject(subject);
		jms.send(smm);
	}
	public void sendotp(String receipient,String otp) {
		SimpleMailMessage smm=new SimpleMailMessage();
		smm.setFrom(usermail);
		smm.setTo(receipient);
		smm.setText("otp to login: "+otp);
		smm.setSubject("OTP");
		jms.send(smm);
		
	}

}
