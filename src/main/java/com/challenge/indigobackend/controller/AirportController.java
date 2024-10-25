package com.challenge.indigobackend.controller;

import com.challenge.indigobackend.model.Airport;
import com.challenge.indigobackend.service.AirportService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/airport")
public class AirportController {

    private final AirportService airportService;

    @GetMapping
    public ResponseEntity<List<Airport>> getAllAirports() {
        return ResponseEntity.ok(airportService.getAllAirports());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable Long id) {
        Optional<Airport> airport = airportService.getAirportById(id);
        return airport.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Airport> createAirport(@RequestBody Airport airport) {
        Airport newAirport = airportService.createAirport(airport);
        return ResponseEntity.ok(newAirport);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Airport> updateAirport(@PathVariable Long id, @RequestBody Airport airportDetails) {
        try {
            Airport updatedAirport = airportService.updateAirport(id, airportDetails);
            return ResponseEntity.ok(updatedAirport);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable Long id) {
        try {
            airportService.deleteAirport(id);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
