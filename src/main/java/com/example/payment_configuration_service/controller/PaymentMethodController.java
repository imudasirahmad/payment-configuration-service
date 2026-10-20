package com.example.payment_configuration_service.controller;
import com.example.payment_configuration_service.dto.PaymentMethodsResponse;
import com.example.payment_configuration_service.service.PaymentMethodService;
import org.springframework.http.HttpStatus;
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
    public PaymentMethodsResponse getAllPaymentMethods(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "id", required = false) Long id) {
        boolean isNameIncluded = name != null && !name.isBlank();
        boolean isIdIncluded = id != null;


           if (isNameIncluded && isIdIncluded){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Both 'name' and 'id' parameters cannot be provided simultaneously.");
            }
            if(isNameIncluded){
                return new PaymentMethodsResponse(paymentMethodService.filterByName(name));
            }
           if(isIdIncluded){
                return new PaymentMethodsResponse(paymentMethodService.filterById(id));
            }
           else{
                return new PaymentMethodsResponse(paymentMethodService.getAllPaymentMethods());
            }
    }
}
