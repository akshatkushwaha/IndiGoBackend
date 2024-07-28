package com.challenge.indigobackend.service;

import com.challenge.indigobackend.model.Subscription;
import com.challenge.indigobackend.model.Users;
import com.challenge.indigobackend.repository.SubscriptionRepository;
import com.challenge.indigobackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class NotificationService {

    private UserRepository userRepository;

    private SubscriptionRepository subscriptionRepository;


    private void sendSMS(String message, String phoneNumber) {
        // Implement SMS sending logic here
        System.out.println("Sending SMS to " + phoneNumber + ": " + message);
    }

    private void sendAppNotification(String message, String userId) {
        // Implement App notification logic here
        System.out.println("Sending App Notification to " + userId + ": " + message);
    }

    private void sendEmail(String message, String toEmail) {
        // Implement email sending logic here
        System.out.println("Sending Email to " + toEmail + ": " + message);
    }

    @KafkaListener(topics = "FlightUpdates", groupId = "flights-group")
    public void consume(String message) {
        System.out.println("Received: " + message);

        Long flightId = extractFlightIdFromMessage(message);

        List<Subscription> subscriptions = subscriptionRepository.findByFlightId(flightId);

        List<Users> users = subscriptions.stream().map(subscription -> userRepository.findById(subscription.getUserId()).orElse(null)).filter(Objects::nonNull).collect(Collectors.toList());

        for (Users user : users) {
            sendSMS(message, user.getPhone());
            sendAppNotification(message, user.getId().toString());
            sendEmail(message, user.getEmail());
        }
    }

    private Long extractFlightIdFromMessage(String message) {
        return Long.parseLong(message.split(":")[1].trim());
    }
}
