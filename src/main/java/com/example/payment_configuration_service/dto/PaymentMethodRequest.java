package com.example.payment_configuration_service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@Getter
@Setter
public class PaymentMethodRequest {

    private String name;
    private String displayName;
    private String paymentType;
    private List<PaymentPlanRequest> paymentPlans;
}
