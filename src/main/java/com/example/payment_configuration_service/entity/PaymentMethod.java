package com.example.payment_configuration_service.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "payment_methods")
public class PaymentMethod {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String name;
    private String displayName;
    private String paymentType;

    public PaymentMethod() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
     public void setName(String name){
         this.name = name;
     }
    public String getDisplayName(){
        return displayName;
    }
    public void setDisplayName(String displayName){
        this.displayName = displayName;
    }
    public String getPaymentType(){
        return paymentType;
    }
    public void setPaymentType(String paymentType){
        this.paymentType = paymentType;
    }
}
