package com.jemgroup.unicab.ride;

import com.jemgroup.unicab.dto.JoinRideDTO;
import com.jemgroup.unicab.ride.RideDTO;
import com.jemgroup.unicab.ride.Ride;
import com.jemgroup.unicab.ride.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RideService {

    private RideRepository rideRepository;

    @Autowired
    private RideService(RideRepository rideRepository){
        this.rideRepository = rideRepository;
    }

    public ResponseEntity<?> createRide(RideDTO rideDTO){
        // check for null values in rideDTO
        // check for best case
        if (rideDTO.getDriver() ==  null || rideDTO.getDriver().isEmpty()) {
            return new ResponseEntity<>("Driver name cannot be found", HttpStatus.BAD_REQUEST);
        } else if (rideDTO.getStudent() == null || rideDTO.getStudent().isEmpty()) {
            return new ResponseEntity<>("Student name cannot be found", HttpStatus.BAD_REQUEST);
        } else if (rideDTO.getStartLocation() == null || rideDTO.getStartLocation().isEmpty()) {
            return new ResponseEntity<>("Start Location cannot be found", HttpStatus.BAD_REQUEST);
        } else if (rideDTO.getEndLocation() == null || rideDTO.getEndLocation().isEmpty()) {
            return new ResponseEntity<>("End Location cannot be found", HttpStatus.BAD_REQUEST);
        }
        var result = rideRepository.save(
                new Ride(
                rideDTO.getId(), rideDTO.getDriver(), rideDTO.getStudent(),
                rideDTO.getStartLocation(), rideDTO.getEndLocation(),
                new Date(), null
        ));
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    public ResponseEntity<?> updateRide(RideDTO rideDTO) {
        // Check if the ride with the given ID exists
        Ride _optionalRide = rideRepository.findById(rideDTO.getId()).orElse(null);

        if (_optionalRide != null){
            // Ride with the given ID exists, update its properties

            _optionalRide.setDriver(rideDTO.getDriver());
            _optionalRide.setStudent(rideDTO.getStudent());
            _optionalRide.setStartLocation(rideDTO.getStartLocation());
            _optionalRide.setEndLocation(rideDTO.getEndLocation());

            // Update the updatedAt field
            _optionalRide.setUpdatedAt(new Date());

            // Save the updated ride
            Ride updatedRide = rideRepository.save(_optionalRide);

            return new ResponseEntity<>(updatedRide, HttpStatus.OK);
        } else {
            // Ride with the given ID not found
            return new ResponseEntity<>("Ride not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteRide(RideDTO rideDTO) {

        Ride _optionalRide = rideRepository.findById(rideDTO.getId()).orElse(null);

        if (_optionalRide != null){
            _optionalRide.setDriver(rideDTO.getDriver());
            _optionalRide.setStudent(rideDTO.getStudent());
            _optionalRide.setStartLocation(rideDTO.getStartLocation());
            _optionalRide.setEndLocation(rideDTO.getEndLocation());

            _optionalRide.setUpdatedAt(new Date());

            Ride deletedRide = rideRepository.save(_optionalRide);

            return new ResponseEntity<>(deletedRide, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Ride not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> joinRide(JoinRideDTO joinRideDTO){
        Ride rideToJoin = rideRepository.findById(joinRideDTO.getId()).orElse(null);

        if (rideToJoin != null) {
            // Check if the ride already has a student
            if (rideToJoin.getStudent() != null) {
                return new ResponseEntity<>("Ride already has a student", HttpStatus.BAD_REQUEST);
            }

            // Set the new student
            rideToJoin.setStudent(joinRideDTO.getStudent());
            rideToJoin.setEndLocation(joinRideDTO.getEndLocation());
            rideToJoin.setUpdatedAt(new Date());

            // Save the updated ride
            Ride updatedRide = rideRepository.save(rideToJoin);

            return new ResponseEntity<>(updatedRide, HttpStatus.OK);
        } else {
            // Ride with the given ID not found
            return new ResponseEntity<>("Ride not found", HttpStatus.NOT_FOUND);
        }
    }
}




