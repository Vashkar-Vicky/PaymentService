package org.example.paymentservice.dtos;


import lombok.Data;

@Data
public class PaymentRequest {
    private long orderId;
    private long amount ;
}
