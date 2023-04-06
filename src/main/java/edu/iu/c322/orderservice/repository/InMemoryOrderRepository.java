package edu.iu.c322.orderservice.repository;

import edu.iu.c322.orderservice.model.Item;
import edu.iu.c322.orderservice.model.Order;
import edu.iu.c322.orderservice.model.Return;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


public class InMemoryOrderRepository {
    private List<Order> orders = new ArrayList<>();

    public Order findById(int id){
        for(Order order: orders){
            if (order.getId()==id){
                return order;
            }
        }
        throw new IllegalStateException("order id is not valid.");
    }

    public int create(Order order){
        int id = orders.size() + 1;
        order.setId(id);
        orders.add(order);
        return order.getId();
    }

    public void update(Return returnOrder){
        Order order = findById(returnOrder.getOrderId());
        if (order == null) {
            throw new IllegalStateException("Order with id " + returnOrder.getOrderId() + " not found.");
        }

        // Find the item with the given id and mark it as returned
        for (Item item : order.getItems()) {
            if (item.getId() == returnOrder.getItemId()) {
                item.setStatus("returned");
                return;
            }
        }

        throw new IllegalStateException("Item with id " + returnOrder.getItemId() + " not found in order with id " + returnOrder.getOrderId() + ".");

    }

    public void delete(int id){
        Order order = findById(id);
        order.setStatus("canceled");


    }



    private Order getOrderById(int id) {
        return orders.stream().filter(x -> x.getId() == id).findAny().orElse(null);
    }
}
