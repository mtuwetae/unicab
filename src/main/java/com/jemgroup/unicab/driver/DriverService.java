package com.jemgroup.unicab.driver;

import com.jemgroup.unicab.driver.DriverDTO;
import com.jemgroup.unicab.driver.Driver;
import com.jemgroup.unicab.driver.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;

    public Driver saveDriver(DriverDTO driverDTO){
        Driver driverDetails = new Driver();
        driverDetails.setName(driverDTO.getName());
        driverDetails.setLicenseNumber(driverDTO.getLicenseNumber());
        driverDetails.setTelephoneNumber(driverDTO.getTelephoneNumber());
        driverDetails.setVehicleDetails(driverDTO.getVehicleDetails());
        driverDetails.setDriverImage(driverDTO.getDriverImage());
        driverDetails.setNationalIdImageUrl(driverDTO.getNationalIdImageUrl());
        try {
            driverRepository.save(driverDetails);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return driverDetails;
    }
}
