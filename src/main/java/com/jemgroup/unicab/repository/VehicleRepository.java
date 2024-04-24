package com.jemgroup.unicab.repository;

import com.jemgroup.unicab.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
