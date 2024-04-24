package com.jemgroup.unicab.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private DriverService driverService;

    @PostMapping("/create")
    public Driver createDriver(@RequestBody DriverDTO driver){
        return driverService.saveDriver(driver);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('DRIVER','ADMIN')")
    public Driver getDriver(@PathVariable Long id){
        return driverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found with id: " + id));
    }

    @PutMapping("/{id}")
    public Driver updateDriver(@PathVariable Long id, @RequestBody Driver updatedDriver) {
        return driverRepository.findById(id)
                .map(driver -> {
                    driver.setName(updatedDriver.getName());
                    driver.setLicenseNumber(updatedDriver.getLicenseNumber());
                    driver.setVehicleDetails(updatedDriver.getVehicleDetails());
                    driver.setDriverImage(updatedDriver.getDriverImage());
                    driver.setNationalIdImageUrl(updatedDriver.getNationalIdImageUrl());
                    return driverRepository.save(driver);
                })
                .orElseThrow(() -> new RuntimeException("Driver not with id: " + id));
    }

    @DeleteMapping("/{id}")
    public void deleteDriver(@PathVariable Long id) {
        driverRepository.deleteById(id);
    }



}
