package org.example.paymentservice.config;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.example.paymentservice.paymentGateway.RazorpayPaymentGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorPayConfig {

    @Bean
    public RazorpayClient getRazorPayClient() throws RazorpayException{
        return new RazorpayClient("rzp_test_1wtdbiYgI97sMD", "sSH8QbI3mxprJHuCHoZPdEwI");
    }
}
