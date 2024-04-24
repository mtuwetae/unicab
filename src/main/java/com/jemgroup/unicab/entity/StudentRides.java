package com.jemgroup.unicab.entity;

import com.jemgroup.unicab.ride.Ride;
import com.jemgroup.unicab.student.Student;
import jakarta.persistence.*;

@Entity
@Table(name = "student_ride")
public class StudentRides {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "ride_id", nullable = false)
    private Ride ride;
}
