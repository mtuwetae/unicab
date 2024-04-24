package com.jemgroup.unicab.dto;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@Data
@ToString
public class JoinRideDTO  {
    private Long Id;
    private String student;
    private String endLocation;
}
