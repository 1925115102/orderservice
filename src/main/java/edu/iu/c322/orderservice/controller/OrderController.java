package edu.iu.c322.orderservice.controller;

import edu.iu.c322.orderservice.model.Item;
import edu.iu.c322.orderservice.model.Order;
import edu.iu.c322.orderservice.model.Return;
import edu.iu.c322.orderservice.repository.OrderRepository;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    // Get localhost:8080/orders
    @GetMapping("/{id}")
    public Order findById(@PathVariable int id){
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
    }

    @PostMapping
    public int create(@Valid @RequestBody Order order){
        Order newOrder = repository.save(order);
        return newOrder.getId();
    }

    // PUT localhost:8080/order/2
    @PutMapping("/return")
    public void update(@Valid @RequestBody Return returnOrder){
        int orderNumber = returnOrder.getOrderId();
        // get the object
        Order order = repository.findById(returnOrder.getOrderId())
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
        // delete the original order
        repository.deleteById(orderNumber);
        // get the item
        order.getItems().get(returnOrder.getItemId()).setStatus("returned");
        // save the original one
        repository.save(order);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        repository.deleteById(id);
    }
}
