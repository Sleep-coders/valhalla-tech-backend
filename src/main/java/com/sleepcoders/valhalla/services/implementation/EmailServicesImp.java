package com.sleepcoders.valhalla.services.implementation;

import com.sleepcoders.valhalla.models.products.Product;
import com.sleepcoders.valhalla.models.users.User;
import com.sleepcoders.valhalla.repository.UserRepository;
import com.sleepcoders.valhalla.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmailServicesImp implements EmailService {

    private final static String EMAIL = "valhallatechasac@gmail.com";
    private final static String PASSWORD = "jpgdxiwalhpzwqob";
    private final UserRepository userRepository;
    private final JavaMailSender javaMailSender;
    private final SpringTemplateEngine thymeleafTemplateEngine;

    @Autowired
    public EmailServicesImp(UserRepository userRepository, JavaMailSender javaMailSender, SpringTemplateEngine thymeleafTemplateEngine) {
        this.userRepository = userRepository;
        this.javaMailSender = javaMailSender;
        this.thymeleafTemplateEngine = thymeleafTemplateEngine;
    }

    @Override
    public void sendHtmlMessage(String to, String subject, String htmlBody) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        mimeMessageHelper.setFrom(EmailServicesImp.EMAIL);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(htmlBody, true);

        javaMailSender.send(mimeMessage);
    }

    @Override
    public void sendThymeleafTemplateMessage(String to, String subject, Map<String, Object> templateModel, String documentType) throws MessagingException {
        Context thymeleafContext = new Context();
        thymeleafContext.setVariables(templateModel);
        String htmlBody;

        if(documentType.equals("invoice"))
            htmlBody = thymeleafTemplateEngine.process("invoice.html", thymeleafContext);
        else
            htmlBody = thymeleafTemplateEngine.process("advertisement.html", thymeleafContext);
        sendHtmlMessage(to, subject, htmlBody);
    }

    public ResponseEntity<String> emailSender(Long userId){
        User user = userRepository.getById(userId);
        String CreditCardsFourDigits = user.getCreditCard().getCreditCardNumber().toString().substring(11);

        Map<String, Object> thymeleafModel = new HashMap<>();
        thymeleafModel.put("lastName", user.getLastName());
        thymeleafModel.put("firstName", user.getFirstName());
        thymeleafModel.put("userBalance", user.getBalance());
        thymeleafModel.put("creditCardDigits", CreditCardsFourDigits);
        thymeleafModel.put("payment", user.getLastPayment());
        try {
            sendThymeleafTemplateMessage(user.getEmail(),
                    "Payment Invoice",
                    thymeleafModel,
                    "invoice");
            return ResponseEntity.ok("Invoice email sent successfully");
        } catch (MessagingException e) {
            e.printStackTrace();
            return ResponseEntity.ok("Failed to send invoice email!");
        }
    }

    public ResponseEntity<String> emailSender(Product product){
        List<User> userList = userRepository.findAll();
        Map<String, Object> thymeleafModel = new HashMap<>();
        thymeleafModel.put("name", product.getName());
        thymeleafModel.put("price", product.getPrice());
        thymeleafModel.put("model", product.getModel());
        thymeleafModel.put("brand", product.getBrand());
        thymeleafModel.put("imagesList", product.getImageUrlList());

        for(User user: userList) {
            try {
                sendThymeleafTemplateMessage(user.getEmail(), "Advertising", thymeleafModel, "Advertising");
            } catch (MessagingException e) {
                e.printStackTrace();
                return ResponseEntity.ok("Failed to send Advertising emails!");
            }
        }
        return ResponseEntity.ok("Advertising emails sent successfully");
    }
}
