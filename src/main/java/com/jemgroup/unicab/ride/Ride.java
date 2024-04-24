package com.jemgroup.unicab.ride;

import com.jemgroup.unicab.student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.*;

@Entity
@Getter
@Setter
@Table(name = "Ride")
@NoArgsConstructor
@AllArgsConstructor
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String driver;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ride_id")
    private Set<Student> students = new HashSet<>();

    private String startLocation;

    private String endLocation;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Ride(){
        this.createdAt = new Date();
    }

    public Ride(Long id, String driver, String student, String startLocation, String endLocation, Date date, Object o) {
        this.id = id;
        this.driver = driver;
        this.startLocation = startLocation;
        this.endLocation = endLocation;

    }

    //Add a method to add a single student
    public void addStudent(Student student) {
        this.students.add(student);
    }

    //Add a method to add multiple students
    public void addStudents(Set<Student> students) {
        this.students.addAll(students);
    }

}
