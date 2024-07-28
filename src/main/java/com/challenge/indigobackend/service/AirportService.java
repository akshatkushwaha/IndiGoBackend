package com.challenge.indigobackend.service;

import com.challenge.indigobackend.model.Airport;
import com.challenge.indigobackend.repository.AirportRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AirportService {
    private final AirportRepository airportRepository;

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public Optional<Airport> getAirportById(Long id) {
        return airportRepository.findById(id);
    }

    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    public Airport updateAirport(Long id, Airport airportDetails) {
        Optional<Airport> optionalAirport = airportRepository.findById(id);
        if (optionalAirport.isPresent()) {
            Airport airport = optionalAirport.get();
            airport.setCode(airportDetails.getCode());
            airport.setName(airportDetails.getName());
            airport.setCity(airportDetails.getCity());
            airport.setCountry(airportDetails.getCountry());
            return airportRepository.save(airport);
        } else {
            throw new RuntimeException("Airport not found with id " + id);
        }
    }

    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }
}
