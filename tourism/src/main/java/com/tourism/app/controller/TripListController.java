package com.tourism.app.controller;

import com.tourism.app.model.TripTourist;
import com.tourism.app.service.tripList.TripListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 Controller that fitch Tips in a List
 and provide an advance search by Name or by City
 */
@RestController
@RequestMapping("/trip/list")
public class TripListController {
    private TripListService tripListService;

    @Autowired
    public TripListController(TripListService tripListService) {
        this.tripListService = tripListService;
    }

    //Get all Tips
    @GetMapping("/all-trips")
    public ResponseEntity<List<TripTourist>> getAllTrips(){
        List<TripTourist> list = tripListService.retrieveTrips();
        return new ResponseEntity<List<TripTourist>>(list, HttpStatus.OK);
    }

    //Get Trips by Name
    @GetMapping("/trip-by-name/{tripName}")
    public ResponseEntity<List<TripTourist>> getTripByName(@PathVariable String tripName){
       List<TripTourist> list = tripListService.retrieveTripsByName(tripName);
       return new ResponseEntity<List<TripTourist>>(list, HttpStatus.OK);
    }

    //Get Trips by City
    /*public ResponseEntity<List<Trip>> getTripsByCity(){
     return null;
    }

     */
}