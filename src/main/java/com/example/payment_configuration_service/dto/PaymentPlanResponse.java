package com.example.payment_configuration_service.dto;
import com.example.payment_configuration_service.entity.PaymentPlan;
import java.math.BigDecimal;

public class PaymentPlanResponse {
    private final Long id;
    private final BigDecimal netAmount;
    private final BigDecimal taxAmount;
    private final BigDecimal grossAmount;
    private final String currency;
    private final String duration;

    public PaymentPlanResponse(PaymentPlan paymentPlan) {
        this.id = paymentPlan.getId();
        this.netAmount = paymentPlan.getNetAmount();
        this.taxAmount = paymentPlan.getTaxAmount();
        this.grossAmount = paymentPlan.getGrossAmount();
        this.currency = paymentPlan.getCurrency();
        this.duration = paymentPlan.getDuration();
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public BigDecimal getGrossAmount() {
        return grossAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getDuration() {
        return duration;
    }
}
