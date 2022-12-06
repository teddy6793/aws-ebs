package com.tien.web_shop_online.services.impl;

import com.tien.web_shop_online.services.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailImplement implements SendMailService {

    @Autowired
    JavaMailSender sender;

    @Override
    public void sendMail(String toEmail, String subject, String body,String typeMail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("phamdinhquochoa101@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        try {
            sender.send(message);
        } catch (Exception e){
            throw  e;
        }

        System.out.println(typeMail + " was sent to " + toEmail + " successfully!");
    }
}
