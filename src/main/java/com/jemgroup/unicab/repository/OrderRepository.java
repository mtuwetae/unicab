package com.jemgroup.unicab.repository;

import com.jemgroup.unicab.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {



}
