package com.jemgroup.unicab.user;

import com.jemgroup.unicab.entity.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;

@Setter
@Getter
@Entity
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String userName;


    private String firstName;
    private String lastName;

    private String telephoneNumber;

    private String email;

    private String password;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    public String getName() {
        return firstName + " " + lastName;
    }

    @PrePersist
    public void prePersist() {
        this.name = firstName + " " + lastName;
    }

//    @ManyToMany
//    @JoinTable(
//        name = "users_roles",
//        joinColumns = @JoinColumn(
//          name = "user_id", referencedColumnName = "id"),
//        inverseJoinColumns = @JoinColumn(
//          name = "role_id", referencedColumnName = "id"))
//
//    private Collection<Role> roles;




}