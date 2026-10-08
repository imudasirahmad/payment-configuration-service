package com.example.payment_configuration_service.repository;
import com.example.payment_configuration_service.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends  JpaRepository<PaymentMethod, Long> {

}
