package com.tourism.app.tripManagment.controller;

import com.tourism.app.tripManagment.exception.TripNotFoundException;
import com.tourism.app.tripManagment.model.Trip;
import com.tourism.app.tripManagment.repository.TripManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/*
 Controller to manage Trips
 for Tourist and Tour Guide
 */
@RestController
@RequestMapping("/trip")
public class TripManagerController {
    @Autowired
    private TripManagerRepo tripManagerRepo;

    //add new trip
    @PostMapping("/new-trip")
    public Trip addTrip(@RequestBody Trip trip){
        return tripManagerRepo.save(trip);
    }

    //Update Trip by id

    @PutMapping("/update-trip/{id}")
    public ResponseEntity<Trip> updateTrip(@PathVariable(value = "id") Long tripId,
                                           @RequestBody Trip tripDetails) throws TripNotFoundException {
        Trip trip = tripManagerRepo.findById(tripId)
                .orElseThrow(() -> new TripNotFoundException("Trip not found for this Id :: " + tripId));

        trip.setTripName(tripDetails.getTripName());
        trip.setDescription(tripDetails.getDescription());
        trip.setTrajectory(tripDetails.getTrajectory());
        final Trip updatedTrip = tripManagerRepo.save(trip);
        return ResponseEntity.ok(updatedTrip);
    }

    //delete Trip by id
    @DeleteMapping("/delete-trip/{id}")
    public Map<String, Boolean> deleteTrip(@PathVariable(value = "id") long tripId)
        throws TripNotFoundException{
        Trip trip = tripManagerRepo.findById(tripId)
                .orElseThrow(() -> new TripNotFoundException("Trip not found for this id :: " + tripId));
        tripManagerRepo.delete(trip);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;
    }
}
