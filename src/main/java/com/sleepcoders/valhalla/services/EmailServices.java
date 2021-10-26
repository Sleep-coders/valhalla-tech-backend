package com.sleepcoders.valhalla.services;

import com.sleepcoders.valhalla.models.products.Product;
import com.sleepcoders.valhalla.models.users.User;
import com.sleepcoders.valhalla.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;
import java.util.Objects;

@Service
public class EmailServices{

    private final static String EMAIL = "valhallatechasac@gmail.com";
    private final static String PASSWORD = "jpgdxiwalhpzwqob";
    private final UserRepository userRepository;
    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailServices(UserRepository userRepository, JavaMailSender javaMailSender) {
        this.userRepository = userRepository;
        this.javaMailSender = javaMailSender;
    }

    public ResponseEntity<String> sendEmailWithInvoiceAttachment(Model model, Long userId)  {
        try {
            User user = userRepository.getById(userId);
            model.addAttribute("user", user);
            emailSenderWithAttachment(user.getEmail(),
                    String.format("Thank you Mr.%s for choosing owr website",user.getLastName())
                    , "Purchase invoice", "src/main/resources/templates/invoice.html");
            return ResponseEntity.ok("Email send successfully");
        } catch (MessagingException e) {
            e.printStackTrace();
            return ResponseEntity.ok("Failed to send email");
        }
    }

    public ResponseEntity<String> sendEmailWithAdvertisingAttachment(Model model, Product product){
//        model.addAttribute("product", product);
        try {
            List<User> userList = userRepository.findAll();
            for(User user: userList){
                emailSenderWithAttachment(user.getEmail(),
                        "Visit our website for more",
                        "Product Advertisement",
                        "src/main/resources/templates/advertisement.html");
            }
            return ResponseEntity.ok("Email send successfully");
        } catch (MessagingException e) {
            e.printStackTrace();
            return ResponseEntity.ok("Failed to send email");
        }
    }

    private void emailSenderWithAttachment(String to, String body, String subject, String attachment) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        mimeMessageHelper.setFrom(EmailServices.EMAIL);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(subject);

        FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));
        mimeMessageHelper.addAttachment(Objects.requireNonNull(fileSystemResource.getFilename()), fileSystemResource);

        javaMailSender.send(mimeMessage);
    }
}
