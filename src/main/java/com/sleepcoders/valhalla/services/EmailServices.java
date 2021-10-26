package com.sleepcoders.valhalla.services;

import com.sleepcoders.valhalla.models.products.Product;
import com.sleepcoders.valhalla.models.users.User;
import com.sleepcoders.valhalla.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;

@Service
public class EmailServices {

    private final static String EMAIL = "ValhallaTechASAC@gmail.com";
    private final static String PASSWORD = "valhallaTech12345";
    private final UserRepository userRepository;

    @Autowired
    public EmailServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername(EmailServices.EMAIL);
        mailSender.setPassword(EmailServices.PASSWORD);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

    public void sendEmail(Product product){
        List<String> userEmailsList;

        List<User> users = userRepository.findAll();
    }
}
