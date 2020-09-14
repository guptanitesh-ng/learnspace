package com.training.restful;

public class OrderKey {

    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderKey [orderId=" + orderId + "]";
    }

}
