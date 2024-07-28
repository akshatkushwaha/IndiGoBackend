package com.challenge.indigobackend.repository;

import com.challenge.indigobackend.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    void deleteAllByUserId(Long userId);

    void deleteAllByFlightId(Long flightId);

    List<Subscription> findByFlightId(Long flightId);
}
