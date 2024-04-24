package com.jemgroup.unicab.ride;

import com.jemgroup.unicab.dto.JoinRideDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/rides")
public class RideController {

    private RideService rideService;

    @Autowired
    public RideController(RideService rideService) {
        this.rideService = rideService;
    }

    private final Logger log = LoggerFactory.getLogger(RideController.class);

    @PostMapping("/create")
    public ResponseEntity<?> createRide(@RequestBody RideDTO rideDTO) {
        try {
            log.info("Request to create ride: {}", rideDTO);
            return rideService.createRide(rideDTO);
        } catch (Exception err) {
            log.info("Error saving ride: {}", err.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRide(@RequestBody RideDTO rideDTO){
        try{
            log.info("Request to update ride: {}", rideDTO);
            return rideService.updateRide(rideDTO);
        }catch (Exception err) {
            log.info("Error saving ride: {}", err.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRide(@RequestBody RideDTO rideDTO) {
        try{
            log.info("Request to delete ride: {}", rideDTO);
            return rideService.deleteRide(rideDTO);
        }catch (Exception err) {
            log.info("Error deleting ride: {}", err.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/join")
    public ResponseEntity<?> joinRide(@RequestBody JoinRideDTO joinRideDTO) {

        try{
            log.info("Request to join ride: {}", joinRideDTO);
            return rideService.joinRide(joinRideDTO);
        }catch (Exception err) {
            log.info("Error joining ride: {}", err.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
