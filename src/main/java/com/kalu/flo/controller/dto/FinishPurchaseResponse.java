package com.kalu.flo.controller.dto;

public class FinishPurchaseResponse {

    private final Integer orderId;

    public FinishPurchaseResponse(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderId() {
        return orderId;
    }
}
