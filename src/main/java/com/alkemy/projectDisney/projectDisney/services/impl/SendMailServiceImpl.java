package com.alkemy.projectDisney.projectDisney.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SendMailServiceImpl {
    @Autowired
    private JavaMailSender javaMailSender;

    @Async
    public void sendWelcomeEmailTo(String email){

        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(email);
        mensaje.setFrom("noreply@disneyalkemy.com");
        mensaje.setSubject("Welcome To Disney Alkemy Project");
        mensaje.setText("Welcome "+email+" to disney!, Let's checkout my project https://github.com/Panchuza/ProjectDisney");

        javaMailSender.send(mensaje);
    }
}
