package edu.iu.c322.orderservice.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Order {
    private int customerId;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private double total;

    @OneToOne
    @JoinColumn(name = "shippingAddress_id", referencedColumnName = "id")
    private @Valid Address address;

    @OneToMany(mappedBy = "order")
    private List<@Valid Item> items;

    @OneToOne
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private @Valid Payment payment;
    private String status;

    public Order(){
        this.status = "ordered";
    }

//    public Order(int customerId, double total, Address shippingAddress, List<Item> items, Payment payment) {
//        this.customerId = customerId;
//        this.total = total;
//        this.shippingAddress = shippingAddress;
//        this.items = items;
//        for (int i = 0; i < items.size(); i++){
//            items.get(i).setId(i+1);
//        }
//        this.payment = payment;
//        this.status = "ordered";
//    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = new ArrayList<>();
        for (int i = 0; i < items.size();i++) {
            Item temp = items.get(i);
            temp.setId(i+1);
            items.add(temp);
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return customerId == order.customerId && Double.compare(order.total, total) == 0 && address.equals(order.address) && items.equals(order.items) && payment.equals(order.payment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, total, address, items, payment);
    }
}
