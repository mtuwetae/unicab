package com.jemgroup.unicab.service;

import com.jemgroup.unicab.dto.VehicleDTO;
import com.jemgroup.unicab.entity.Vehicle;
import com.jemgroup.unicab.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    public Vehicle saveVehicle(VehicleDTO vehicleDTO){
        Vehicle vehicleDetails = new Vehicle();
        vehicleDetails.setRegistrationPlates(vehicleDTO.getRegistrationPlates());
        vehicleDetails.setRoute(vehicleDTO.getRoute());
        vehicleDetails.setModel(vehicleDTO.getModel());
        try{
            vehicleRepository.save(vehicleDetails);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return vehicleDetails;
    }
}
