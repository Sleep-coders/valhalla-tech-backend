package com.sleepcoders.valhalla.services;

import javax.mail.MessagingException;
import java.util.Map;

public interface EmailService {
//    void sendSimpleEmail(String to, String subject, String body);
    void sendHtmlMessage(String to, String subject, String htmlBody) throws MessagingException;
    void sendThymeleafTemplateMessage(String to, String subject, Map<String, Object> templateModel, String documentType) throws MessagingException;
}
