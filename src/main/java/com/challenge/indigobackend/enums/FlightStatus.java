package com.challenge.indigobackend.enums;

import jakarta.persistence.Entity;

public enum FlightStatus {
    SCHEDULED,
    DELAYED,
    CANCELLED,
    DEPARTED,
    LANDED,
    IN_AIR,
    ON_TIME
}
