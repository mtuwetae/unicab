package com.jemgroup.unicab.student;

import com.jemgroup.unicab.ride.Ride;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String university;
    private String schoolId;
    private String telephoneNumber;
    private String email;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "ride_id")
    private Ride ride;

}
