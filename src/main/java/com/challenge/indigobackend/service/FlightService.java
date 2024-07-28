package com.challenge.indigobackend.service;

import com.challenge.indigobackend.model.Flight;
import com.challenge.indigobackend.repository.FlightRepository;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class FlightService {
    private final FlightRepository flightRepository;

    private final KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "FlightUpdates";

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(Long id) {
        return flightRepository.findById(id);
    }

    public Flight createFlight(Flight flight) {
        Flight savedFlight = flightRepository.save(flight);
        kafkaTemplate.send(TOPIC, "Flight created: " + savedFlight.getFlightNumber());
        return savedFlight;
    }

    public Flight updateFlight(Long id, Flight flightDetails) {
        Optional<Flight> optionalFlight = flightRepository.findById(id);
        if (optionalFlight.isPresent()) {
            Flight flight = getFlight(flightDetails, optionalFlight);
            Flight updatedFlight = flightRepository.save(flight);
            kafkaTemplate.send(TOPIC, "Flight updated: " + updatedFlight.getFlightNumber());
            return updatedFlight;
        } else {
            throw new RuntimeException("Flight not found with id " + id);
        }
    }

    private static Flight getFlight(Flight flightDetails, Optional<Flight> optionalFlight) {
        Flight flight = optionalFlight.get();
        flight.setFlightNumber(flightDetails.getFlightNumber());
        flight.setAirline(flightDetails.getAirline());
        flight.setDepartureAirport(flightDetails.getDepartureAirport());
        flight.setArrivalAirport(flightDetails.getArrivalAirport());
        flight.setDepartureTime(flightDetails.getDepartureTime());
        flight.setArrivalTime(flightDetails.getArrivalTime());
        flight.setStatus(flightDetails.getStatus());
        flight.setGate(flightDetails.getGate());
        return flight;
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
        kafkaTemplate.send(TOPIC, "Flight deleted with id " + id);
    }
}
