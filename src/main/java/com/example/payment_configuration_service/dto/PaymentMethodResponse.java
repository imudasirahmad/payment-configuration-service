package com.example.payment_configuration_service.dto;
import com.example.payment_configuration_service.entity.PaymentMethod;
import java.util.List;

public class PaymentMethodResponse {
    private final String name;
    private final String displayName;
    private final String paymentType;
    private final List<PaymentPlanResponse> plans;

    public PaymentMethodResponse(PaymentMethod paymentMethod, List<PaymentPlanResponse> plans) {
        this.name = paymentMethod.getName();
        this.displayName = paymentMethod.getDisplayName();
        this.paymentType = paymentMethod.getPaymentType();
        this.plans = plans;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }
    public String getPaymentType() {
        return paymentType;
    }
    public List<PaymentPlanResponse> getPlans() {
        return plans;
    }
}
