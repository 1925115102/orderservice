package edu.iu.c322.orderservice.controller;

import edu.iu.c322.orderservice.model.Order;
import edu.iu.c322.orderservice.repository.OrderRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return repository.findById(id);
    }

    @PostMapping
    public int create(@Valid @RequestBody Order order){
        return repository.create(order);
    }

    // PUT localhost:8080/order/2
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Order order, @PathVariable int id){
        repository.update(order, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        repository.delete(id);
    }
}
