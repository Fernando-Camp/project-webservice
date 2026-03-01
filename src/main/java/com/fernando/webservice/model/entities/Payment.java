package com.fernando.webservice.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fernando.webservice.model.entities.enums.PaymentType;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_payment")
public class Payment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;
    private Double amount;
    private Integer paymentType;

    @JsonIgnore
    @OneToOne
    @MapsId
    private Order order;

    public Payment() {}

    public Payment(Long id, Instant moment, Double amount, PaymentType paymentType,  Order order) {
        this.id = id;
        this.moment = moment;
        this.amount = amount;
        setPaymentType(paymentType);
        this.order = order;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Instant getMoment() {
        return moment;
    }
    public void setMoment(Instant moment) {
        this.moment = moment;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public PaymentType getPaymentType() {
        return PaymentType.valueOf(paymentType);
    }
    public void setPaymentType(PaymentType paymentType) {
        if(paymentType != null) {
            this.paymentType = paymentType.getCode();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
