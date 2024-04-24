package com.jemgroup.unicab.driver;

import com.jemgroup.unicab.driver.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
