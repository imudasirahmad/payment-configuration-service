package com.example.payment_configuration_service.dto;

import java.util.List;

public class PaymentMethodsResponse {
    private final List<PaymentMethodResponse> paymentMethods;

    public PaymentMethodsResponse(List<PaymentMethodResponse> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }


    public List<PaymentMethodResponse> getPaymentMethods() {
        return paymentMethods;
    }
}
