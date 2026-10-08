package com.example.payment_configuration_service.controller;
import com.example.payment_configuration_service.dto.PaymentMethodResponse;
import com.example.payment_configuration_service.service.PaymentMethodService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class PaymentMethodController {
    private final PaymentMethodService paymentMethodService;

    public PaymentMethodController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @GetMapping("/api/v1.0/configuration/payment-methods")
    public List<PaymentMethodResponse> getAllPaymentMethods() {
        return paymentMethodService.getAllPaymentMethods();
    }
}
