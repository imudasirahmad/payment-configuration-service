package com.example.payment_configuration_service.repository;
import com.example.payment_configuration_service.entity.PaymentMethod;
import com.example.payment_configuration_service.entity.PaymentPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentPlanRepository extends  JpaRepository<PaymentPlan, Long> {

    List<PaymentPlan> findByPaymentMethod(PaymentMethod paymentMethod);
}
