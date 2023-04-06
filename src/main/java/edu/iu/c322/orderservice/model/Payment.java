package edu.iu.c322.orderservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.Objects;
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotEmpty(message = "method cannot be empty.")
    private String method;
    @NotEmpty(message = "number cannot be empty.")
    private String number;
    @OneToOne
    @JoinColumn(name = "billingAddress_id", referencedColumnName = "id")
    private Address address;

//    public Payment(String method, String number, Address billingAddress) {
//        this.method = method;
//        this.number = number;
//        this.billingAddress = billingAddress;
//    }

    @OneToOne(mappedBy="payment")
    private Order order;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return method.equals(payment.method) && number.equals(payment.number) && address.equals(payment.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, number, address);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "method='" + method + '\'' +
                ", number='" + number + '\'' +
                ", billingAddress=" + address +
                '}';
    }
}
