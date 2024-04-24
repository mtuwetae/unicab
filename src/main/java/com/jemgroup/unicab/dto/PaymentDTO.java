package com.jemgroup.unicab.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class PaymentDTO {
    private String mpesa;
    private String airtelMoney;
    private String debitCard;
    private String creditCard;
    private String cash;
}
