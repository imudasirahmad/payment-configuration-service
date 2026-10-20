package com.example.payment_configuration_service.dto;
import com.example.payment_configuration_service.entity.PaymentMethod;
import java.util.List;

public class PaymentMethodResponse {
    private final String name;
    private final String displayName;
    private final String paymentType;
    private final List<PaymentPlanResponse> paymentPlans;

    public PaymentMethodResponse(PaymentMethod paymentMethod, List<PaymentPlanResponse> paymentPlans) {
        this.name = paymentMethod.getName();
        this.displayName = paymentMethod.getDisplayName();
        this.paymentType = paymentMethod.getPaymentType();
        this.paymentPlans = paymentPlans;
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
    public List<PaymentPlanResponse> getPaymentPlans() {
        return paymentPlans;
    }
}
