package com.example.payment_configuration_service.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payment_methods")
@Getter
@Setter
public class PaymentMethod {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String name;
    private String displayName;
    private String paymentType;

    public PaymentMethod() {
    }

}
