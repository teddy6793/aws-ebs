package com.tien.web_shop_online.services;

public interface SendMailService {
    void sendMail(String toEmail, String subject, String body, String typeMail);
}
