package edu.iu.c322.orderservice.model;

public class Return {
    private int orderId;
    private int itemId;
    private String reason;

    public Return(int orderId, int itemId, String reason) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.reason = reason;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
