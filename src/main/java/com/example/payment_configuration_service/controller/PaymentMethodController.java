package com.example.payment_configuration_service.controller;
import com.example.payment_configuration_service.dto.PaymentMethodsResponse;
import com.example.payment_configuration_service.service.PaymentMethodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
//@AllArgsConstructor
public class PaymentMethodController {
    private final PaymentMethodService paymentMethodService;

    public PaymentMethodController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @GetMapping("/api/v1.0/configuration/payment-methods")
    public PaymentMethodsResponse getAllPaymentMethods(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "planId", required = false) Long planId) {
        boolean isNameIncluded = name != null && !name.isBlank();
        boolean isPlanIdIncluded = planId != null;


           if (isNameIncluded && isPlanIdIncluded){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Both 'name' and 'planId' parameters cannot be provided simultaneously.");
            }
            if(isNameIncluded){
                return new PaymentMethodsResponse(paymentMethodService.filterByName(name));
            }
           if(isPlanIdIncluded){
                return new PaymentMethodsResponse(paymentMethodService.filterByPlanId(planId));
            }
           else{
                return new PaymentMethodsResponse(paymentMethodService.getAllPaymentMethods());
            }
    }
}
