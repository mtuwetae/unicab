package com.jemgroup.unicab.driver;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverDTO {
    private String name;
    private String telephoneNumber;
    private String licenseNumber;
    private String vehicleDetails;
    private String driverImage;
    private String nationalIdImageUrl;
}
