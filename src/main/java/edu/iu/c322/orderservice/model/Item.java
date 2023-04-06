package edu.iu.c322.orderservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.Objects;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;
    @NotEmpty(message = "item name cannot be empty.")
    private String name;
    private int quantity;
    private int price;

    private String status;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Item(){
        status = "shipping now";
    }

//    public Item(String name, int quantity, int price) {
//        this.name = name;
//        this.quantity = quantity;
//        this.price = price;
//        this.status = "shipping now";
//    }

    public int getId() {
        return itemId;
    }

    public void setId(int id) {
        this.itemId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return quantity == item.quantity && price == item.price && name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quantity, price);
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
