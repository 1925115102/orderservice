package edu.iu.c322.orderservice.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.Objects;
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotEmpty(message = "state cannot be empty.")
    private String state;
    @NotEmpty(message = "city cannot be empty.")
    private String city;

    private int postalCode;

    @OneToOne(mappedBy="address")
    private Order order;


//    public Address(String state, String city, int postalCode) {
//        this.state = state;
//        this.city = city;
//        this.postalCode = postalCode;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        Address that = (Address) o;
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
