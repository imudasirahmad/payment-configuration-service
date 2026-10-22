package com.example.payment_configuration_service.service;

import com.example.payment_configuration_service.dto.PaymentMethodRequest;
import com.example.payment_configuration_service.dto.PaymentMethodResponse;
import com.example.payment_configuration_service.dto.PaymentPlanResponse;
import com.example.payment_configuration_service.entity.PaymentMethod;
import com.example.payment_configuration_service.entity.PaymentPlan;
import com.example.payment_configuration_service.repository.PaymentMethodRepository;
import com.example.payment_configuration_service.repository.PaymentPlanRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public PaymentPlan getPlanById(Long planId){
        return paymentPlanRepository.findById(planId).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Payment plan not found"
        ));
    }
    public List<PaymentMethodResponse> filterById(Long id){

        PaymentPlan paymentPlan = getPlanById(id);
        PaymentMethod paymentMethod = paymentPlan.getPaymentMethod();
        PaymentPlanResponse paymentPlanResponse = new PaymentPlanResponse(paymentPlan);
        List<PaymentPlanResponse> paymentPlanResponses = List.of(paymentPlanResponse);
        PaymentMethodResponse paymentMethodResponse = new PaymentMethodResponse(paymentMethod, paymentPlanResponses);
        return List.of(paymentMethodResponse);
    }
    public List<PaymentPlan> getPaymentPlans(PaymentMethod paymentMethod) {
        return paymentPlanRepository.findByPaymentMethod(paymentMethod);
    }

    PaymentMethod addPaymentMethod(PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    public PaymentMethod addPaymentMethod(PaymentMethodRequest paymentMethodRequest) {
        PaymentMethod paymentMethod = new PaymentMethod();

        paymentMethod.setName(paymentMethodRequest.getName());
        paymentMethod.setDisplayName(paymentMethodRequest.getDisplayName());
        paymentMethod.setPaymentType(paymentMethodRequest.getPaymentType());

        PaymentMethod savedPaymentMethod = paymentMethodRepository.save(paymentMethod);

        boolean isPaymentPlansAvailable = paymentMethodRequest.getPaymentPlans() != null && !paymentMethodRequest.getPaymentPlans().isEmpty();

        if(isPaymentPlansAvailable){
            List<PaymentPlan> paymentPlans = paymentMethodRequest.getPaymentPlans().stream()
                    .map(paymentPlanRequest -> {
                        PaymentPlan paymentPlan = new PaymentPlan();
                        paymentPlan.setNetAmount(paymentPlanRequest.getNetAmount());
                        paymentPlan.setTaxAmount(paymentPlanRequest.getTaxAmount());
                        paymentPlan.setGrossAmount(paymentPlanRequest.getGrossAmount());
                        paymentPlan.setCurrency(paymentPlanRequest.getCurrency());
                        paymentPlan.setDuration(paymentPlanRequest.getDuration());
                        paymentPlan.setPaymentMethod(savedPaymentMethod);
                        return paymentPlan;
                    })
                    .toList();
            paymentPlanRepository.saveAll(paymentPlans);
        }

        return savedPaymentMethod;
    }

}
