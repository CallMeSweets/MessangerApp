package com.communication.messanger.service;

import com.communication.messanger.model.Message;
import com.communication.messanger.service.interfaces.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailSenderService implements EmailSender {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(Message message) throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(message.getEmail());
        mail.setFrom("slawek.kowalski4321@gmail.com");
        mail.setSubject(message.getTitle());
        mail.setText(message.getContent());

        javaMailSender.send(mail);
    }
}
