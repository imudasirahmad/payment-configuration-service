package com.example.payment_configuration_service.service;

import com.example.payment_configuration_service.entity.PaymentMethod;
import com.example.payment_configuration_service.entity.PaymentPlan;
import com.example.payment_configuration_service.repository.PaymentMethodRepository;
import com.example.payment_configuration_service.repository.PaymentPlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentMethodService {
    private final PaymentMethodRepository paymentMethodRepository;
    private final PaymentPlanRepository paymentPlanRepository;

    public PaymentMethodService(PaymentMethodRepository paymentMethodRepository, PaymentPlanRepository paymentPlanRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
        this.paymentPlanRepository = paymentPlanRepository;
    }


    public List<PaymentMethod> getAllPaymentMethods() {
        return paymentMethodRepository.findAll();
    }

    public List<PaymentPlan> getPaymentPlans(PaymentMethod paymentMethod) {
        return paymentPlanRepository.findByPaymentMethod(paymentMethod);
    }
}
