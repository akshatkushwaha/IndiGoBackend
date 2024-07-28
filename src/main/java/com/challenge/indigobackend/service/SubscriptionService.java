package com.challenge.indigobackend.service;

import com.challenge.indigobackend.model.Subscription;
import com.challenge.indigobackend.repository.SubscriptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    public Subscription createSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    public void updateSubscription(Long id, Subscription subscriptionDetails) {
        Subscription subscription = subscriptionRepository.findById(id).orElseThrow(() -> new RuntimeException("Subscription not found with id " + id));
        subscription.setUserId(subscriptionDetails.getUserId());
        subscription.setFlightId(subscriptionDetails.getFlightId());
        subscriptionRepository.save(subscription);
    }

    public void deleteSubscription(Long id) {
        subscriptionRepository.deleteById(id);
    }

    public void deleteAllSubscriptionsByUserId(Long userId) {
        subscriptionRepository.deleteAllByUserId(userId);
    }

    public void deleteAllSubscriptionsByFlightId(Long flightId) {
        subscriptionRepository.deleteAllByFlightId(flightId);
    }
}
