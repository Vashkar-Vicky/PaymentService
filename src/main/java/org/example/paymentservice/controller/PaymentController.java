package org.example.paymentservice.controller;


import org.example.paymentservice.PaymentServiceApplication;
import org.example.paymentservice.dtos.PaymentRequest;
import org.example.paymentservice.service.PaymentService;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private PaymentService paymentService;
    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }
    @PostMapping("/")
    public String initiatePayment(@RequestBody PaymentRequest paymentRequest){
       try{
           return this.paymentService.initiatePayment(paymentRequest.getOrderId(), paymentRequest.getAmount());
       }
       catch(Exception e){
           System.out.println("error is :"+e.getMessage());
           return "ERROR";
       }
//       return null;
    }
}
