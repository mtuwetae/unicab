package com.jemgroup.unicab.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
    private String pickupLocation;
    private Integer seatAvailability;
    private String destinationRoute;
    private Boolean emptySeatAvailability;
}
