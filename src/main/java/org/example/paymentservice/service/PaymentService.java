package org.example.paymentservice.service;


import com.razorpay.RazorpayException;
import com.razorpay.RazorpayClient;
import org.example.paymentservice.PaymentServiceApplication;
import org.example.paymentservice.paymentGateway.PaymentGateway;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PaymentGateway paymentGateway;

    public PaymentService(PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }
    public String initiatePayment(Long orderId , Long amount) throws RazorpayException {
        return paymentGateway.generatePaymentLink(orderId, amount);
    }
}
