package org.example.paymentservice.paymentGateway;

import com.razorpay.RazorpayException;
import org.springframework.boot.configurationprocessor.json.JSONException;

public interface PaymentGateway{
    String generatePaymentLink(Long orderId, Long amount) throws RazorpayException;
}
