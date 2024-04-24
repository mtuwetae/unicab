package com.jemgroup.unicab.repository;

import com.jemgroup.unicab.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
