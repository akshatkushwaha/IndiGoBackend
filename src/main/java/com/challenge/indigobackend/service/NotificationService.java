package com.challenge.indigobackend.service;

import com.challenge.indigobackend.model.Subscription;
import com.challenge.indigobackend.model.Users;
import com.challenge.indigobackend.repository.SubscriptionRepository;
import com.challenge.indigobackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.stream.Collectors;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@AllArgsConstructor
@Service
public class NotificationService {

    private UserRepository userRepository;

    private SubscriptionRepository subscriptionRepository;

    @Value("${spring.mail.username}")
    private String FROM_EMAIL;

    @Value("${spring.mail.password}")
    private String EMAIL_PASSWORD;

    @Value("${spring.mail.host}")
    private String SMTP_HOST;

    @Value("${spring.mail.port}")
    private String SMTP_PORT;

    @Value("${spring.mail.properties.mail.smtp.auth}")
    private String SMTP_AUTH;

    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
    private String SMTP_STARTTLS_ENABLE;

    public NotificationService() {}

//    private void sendSMS(String message, String phoneNumber) {
//        // Implement SMS sending logic here
//        System.out.println("Sending SMS to " + phoneNumber + ": " + message);
//    }
//
//    private void sendAppNotification(String message, String userId) {
//        // Implement App notification logic here
//        System.out.println("Sending App Notification to " + userId + ": " + message);
//    }
//
//    // Method to send email
//    private void sendEmail(String message, String toEmail) {
//        Properties props = new Properties();
//        props.put("mail.smtp.host", SMTP_HOST);
//        props.put("mail.smtp.port", SMTP_PORT);
//        props.put("mail.smtp.auth", SMTP_AUTH);
//        props.put("mail.smtp.starttls.enable", SMTP_STARTTLS_ENABLE); // To enable TLS
//
//        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(FROM_EMAIL, EMAIL_PASSWORD);
//            }
//        });
//
//        try {
//            Message msg = new MimeMessage(session);
//            msg.setFrom(new InternetAddress(FROM_EMAIL, false));
//            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
//            msg.setSubject("Flight Status Update");
//            msg.setContent(message, "text/html");
//            msg.setSentDate(new java.util.Date());
//
//            Transport.send(msg);
//            System.out.println("Email sent to " + toEmail + ": " + message);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//    }

    @KafkaListener(topics = "FlightUpdates", groupId = "flights-group")
    public void consume(String message) {
        System.out.println("Received: " + message);

//        Long flightId = extractFlightIdFromMessage(message);
//
//        List<Subscription> subscriptions = subscriptionRepository.findByFlightId(flightId);
//
//        List<Users> users = subscriptions.stream()
//                .map(subscription -> userRepository.findById(subscription.getUserId()).orElse(null))
//                .filter(Objects::nonNull)
//                .collect(Collectors.toList());
//
//        for (Users user : users) {
//            sendSMS(message, user.getPhone());
//            sendAppNotification(message, user.getId().toString());
//            sendEmail(message, user.getEmail());
//        }
    }
//
//    private Long extractFlightIdFromMessage(String message) {
//        return Long.parseLong(message.split(":")[1].trim());
//    }
}
