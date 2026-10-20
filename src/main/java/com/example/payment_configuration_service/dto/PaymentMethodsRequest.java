package com.example.payment_configuration_service.dto;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor
public class PaymentMethodsRequest {
    List<PaymentMethodRequest> paymentMethods;

    public  PaymentMethodsRequest(List<PaymentMethodRequest> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public List<PaymentMethodRequest> getPaymentMethods() {
        return paymentMethods;
    }
}
