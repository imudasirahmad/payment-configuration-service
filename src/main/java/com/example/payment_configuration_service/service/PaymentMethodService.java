package com.example.payment_configuration_service.service;

import com.example.payment_configuration_service.dto.PaymentMethodResponse;
import com.example.payment_configuration_service.dto.PaymentPlanResponse;
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


    public List<PaymentMethodResponse> getAllPaymentMethods() {

        final List<PaymentMethod> paymentMethods = paymentMethodRepository.findAll();
        final List<PaymentMethodResponse> paymentMethodResponses = new java.util.ArrayList<>();
        paymentMethods.forEach(paymentMethod -> {
            final List<PaymentPlan> paymentPlans = getPaymentPlans(paymentMethod);
            final List<PaymentPlanResponse> paymentPlanResponses = new java.util.ArrayList<>();
            paymentPlans.forEach(paymentPlan -> {
                paymentPlanResponses.add(new PaymentPlanResponse(paymentPlan));

            });
            paymentMethodResponses.add(new PaymentMethodResponse(paymentMethod, paymentPlanResponses));

        });
        return paymentMethodResponses;
    }

    public List<PaymentMethodResponse> filterByName(String name) {
        final List<PaymentMethod> paymentMethods = paymentMethodRepository.findByNameContainingIgnoreCase(name);
        final List<PaymentMethodResponse> paymentMethodResponses = new java.util.ArrayList<>();
        paymentMethods.forEach(paymentMethod -> {
            final List<PaymentPlan> paymentPlans = getPaymentPlans(paymentMethod);
            final List<PaymentPlanResponse> paymentPlanResponses = new java.util.ArrayList<>();
            paymentPlans.forEach(paymentPlan -> {
                paymentPlanResponses.add(new PaymentPlanResponse(paymentPlan));

            });
            paymentMethodResponses.add(new PaymentMethodResponse(paymentMethod, paymentPlanResponses));

        });
        return paymentMethodResponses;
    }

    public List<PaymentPlan> getPaymentPlans(PaymentMethod paymentMethod) {
        return paymentPlanRepository.findByPaymentMethod(paymentMethod);
    }
}
