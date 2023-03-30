package edu.iu.c322.orderservice.model;

import java.util.Objects;

public class Payment {
    private String method;
    private String number;
    private ShippingAddress shippingAddress;

    public Payment(String method, String number, ShippingAddress shippingAddress) {
        this.method = method;
        this.number = number;
        this.shippingAddress = shippingAddress;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return method.equals(payment.method) && number.equals(payment.number) && shippingAddress.equals(payment.shippingAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, number, shippingAddress);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "method='" + method + '\'' +
                ", number='" + number + '\'' +
                ", shippingAddress=" + shippingAddress +
                '}';
    }
}
