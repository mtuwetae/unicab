package com.jemgroup.unicab.driver;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String telephoneNumber;
    private String licenseNumber;
    private String vehicleDetails;
    private String driverImage;
    private String nationalIdImageUrl;
}
