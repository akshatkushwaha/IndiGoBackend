package com.challenge.indigobackend.controller;

import com.challenge.indigobackend.model.Subscription;
import com.challenge.indigobackend.service.SubscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/subscription")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping
    public ResponseEntity<Subscription> createSubscription(Subscription subscription) {
        Subscription newSubscription = subscriptionService.createSubscription(subscription);
        return ResponseEntity.ok(newSubscription);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable Long id) {
        subscriptionService.deleteSubscription(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteAllSubscriptionsByUserId(@PathVariable Long userId) {
        subscriptionService.deleteAllSubscriptionsByUserId(userId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/flight/{flightId}")
    public ResponseEntity<Void> deleteAllSubscriptionsByFlightId(@PathVariable Long flightId) {
        subscriptionService.deleteAllSubscriptionsByFlightId(flightId);
        return ResponseEntity.noContent().build();
    }
}
