package com.fernando.webservice.model.entities.enums;

public enum PaymentType {
    PIX(1),
    CREDIT_CARD(2),
    DEBIT_CARD(3),
    TICKET(4);

    private int code;

    private PaymentType(int value) {
        this.code = value;
    }

    public int getCode() {
        return code;
    }

    public static PaymentType valueOf(int code) {
        for (PaymentType paymentType : PaymentType.values()) {
            if (paymentType.code == code) {
                return paymentType;
            }
        }
        throw new IllegalArgumentException("No constant with code " + code + " found");
    }
}
