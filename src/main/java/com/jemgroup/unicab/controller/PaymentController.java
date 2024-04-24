package com.jemgroup.unicab.controller;

import com.jemgroup.unicab.entity.Payment;
import com.jemgroup.unicab.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentRepository.save(payment);
    }

    @GetMapping("/{id}")
    public Payment getPayment(@PathVariable Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @PutMapping("/{id}")
    public Payment updatePayment(@PathVariable Long id, @RequestBody Payment updatedPayment) {
        return paymentRepository.findById(id)
                .map(payment -> {
                    payment.setMpesa(updatedPayment.getMpesa());
                    payment.setAirtelMoney(updatedPayment.getAirtelMoney());
                    payment.setDebitCard(updatedPayment.getDebitCard());
                    payment.setCreditCard(updatedPayment.getCreditCard());
                    payment.setCash(updatedPayment.getCash());
                    return paymentRepository.save(payment);
                })
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id) {
        paymentRepository.deleteById(id);
    }

}
