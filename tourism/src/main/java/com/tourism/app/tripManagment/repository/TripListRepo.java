package com.tourism.app.tripManagment.repository;

import com.tourism.app.tripManagment.model.TripTourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TripListRepo extends JpaRepository<TripTourist, Long> {
    @Query("select t from trip_tourist t where UPPER(t.tripName) like concat('%', upper(?1),'%')")
    List<TripTourist> findTripsByName(String tripName);
}
