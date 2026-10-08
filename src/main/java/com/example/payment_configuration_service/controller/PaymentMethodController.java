package com.example.payment_configuration_service.controller;
import com.example.payment_configuration_service.dto.PaymentMethodsResponse;
import com.example.payment_configuration_service.service.PaymentMethodService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentMethodController {
    private final PaymentMethodService paymentMethodService;

    public PaymentMethodController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @GetMapping("/api/v1.0/configuration/payment-methods")
    public PaymentMethodsResponse getAllPaymentMethods(@RequestParam(value = "name", required = false) String name) {
        if(name == null || name.isEmpty()){
            return new PaymentMethodsResponse(paymentMethodService.getAllPaymentMethods());
        }else{
            return new PaymentMethodsResponse(paymentMethodService.filterByName(name));
        }
    }
}
