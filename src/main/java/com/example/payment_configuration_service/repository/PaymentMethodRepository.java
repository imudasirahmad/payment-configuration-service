package com.example.payment_configuration_service.repository;
import com.example.payment_configuration_service.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PaymentMethodRepository extends  JpaRepository<PaymentMethod, Long> {

    List<PaymentMethod> findByNameContainingIgnoreCase(String query);
}
