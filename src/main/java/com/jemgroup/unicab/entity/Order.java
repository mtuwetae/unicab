package com.jemgroup.unicab.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "`Order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String pickupLocation;
    private Integer seatAvailability;
    private String destinationRoute;
    private Boolean emptySeatAvailability;
}
