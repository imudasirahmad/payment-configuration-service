package com.example.payment_configuration_service.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class PaymentMethodsRequest {
    List<PaymentMethodRequest> paymentMethods;
}
