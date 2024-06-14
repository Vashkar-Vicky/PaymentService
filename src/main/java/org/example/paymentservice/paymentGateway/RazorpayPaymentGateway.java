package org.example.paymentservice.paymentGateway;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Utils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RazorpayPaymentGateway implements PaymentGateway{

    private RazorpayClient razorpayClient;

    public RazorpayPaymentGateway(RazorpayClient razorpayClient){
        this.razorpayClient = razorpayClient;
    }
    @Override
    public String generatePaymentLink(Long orderId, Long amount) throws RazorpayException{

        RazorpayClient razorpay = new RazorpayClient("rzp_test_1wtdbiYgI97sMD", "sSH8QbI3mxprJHuCHoZPdEwI");


        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount", amount); // 1000 - > 10.00
        paymentLinkRequest.put("currency","INR");
//        paymentLinkRequest.put("accept_partial",true);
//        paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by", 1718399753);
        paymentLinkRequest.put("reference_id", orderId.toString());
        paymentLinkRequest.put("description","Payment for orderId " + orderId.toString());


        // CUSTOMER DETAILS
        JSONObject customer = new JSONObject();
        customer.put("name","+919123456891");
        customer.put("contact","karan bhatia");
        customer.put("email","karan.bhatia_1@scaler.com");
        paymentLinkRequest.put("customer",customer);


        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);

        // notify details..
        paymentLinkRequest.put("notify",notify);
//        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
//        notes.put("policy_name","Jeevan Bima");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://www.scaler.com/academy/mentee-dashboard/");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink link =razorpayClient.paymentLink.create(paymentLinkRequest);

        return link.toString();
    }

}
