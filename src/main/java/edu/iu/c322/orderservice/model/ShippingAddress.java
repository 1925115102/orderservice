package edu.iu.c322.orderservice.model;

import java.util.Objects;

public class ShippingAddress {
    private String state;
    private String city;
    private int postalCode;

    public ShippingAddress(String state, String city, int postalCode) {
        this.state = state;
        this.city = city;
        this.postalCode = postalCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShippingAddress that = (ShippingAddress) o;
        return postalCode == that.postalCode && state.equals(that.state) && city.equals(that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, city, postalCode);
    }

    @Override
    public String toString() {
        return "ShippingAddress{" +
                "state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }
}
