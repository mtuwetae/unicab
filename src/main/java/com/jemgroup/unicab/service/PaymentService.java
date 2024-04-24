package com.jemgroup.unicab.service;


import com.jemgroup.unicab.dto.PaymentDTO;
import com.jemgroup.unicab.entity.Payment;
import com.jemgroup.unicab.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public Payment savePayment(PaymentDTO paymentDTO){
        Payment paymentDetails = new Payment();
        paymentDetails.setMpesa(paymentDTO.getMpesa());
        paymentDetails.setAirtelMoney(paymentDTO.getAirtelMoney());
        paymentDetails.setDebitCard(paymentDTO.getDebitCard());
        paymentDetails.setCreditCard(paymentDTO.getCreditCard());
        paymentDetails.setCash(paymentDTO.getCash());
        try {
            paymentRepository.save(paymentDetails);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return paymentDetails;
    }
}
