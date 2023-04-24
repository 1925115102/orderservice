package edu.iu.c322.orderservice.controller;

import edu.iu.c322.orderservice.model.Item;
import edu.iu.c322.orderservice.model.Order;
import edu.iu.c322.orderservice.repository.OrderRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @PutMapping("/order/{orderId}")
    public ResponseEntity<Order> updateOrder(@PathVariable int orderId, @RequestBody Order updatedOrder) {
        // code to update the order
        return ResponseEntity.ok(updatedOrder);
    }

    @PutMapping("/{orderId}")
    public void updateOrder(@RequestBody Order updatedOrder, @PathVariable int orderId) {
        Order existingOrder = repository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found with id " + orderId));

        // set the order ID to match the path variable
        updatedOrder.setId(orderId);

        // update the items in the order
        for (int i = 0; i < updatedOrder.getItems().size(); i++) {
            Item item = updatedOrder.getItems().get(i);
            item.setOrder(updatedOrder);
        }

        // save the updated order
        repository.save(updatedOrder);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public int create(@RequestBody Order order){

        for(int i = 0; i < order.getItems().size(); i++){
            Item item = order.getItems().get(i);
            item.setOrder(order);
        }
        Order addedOrder = repository.save(order);
        return addedOrder.getId();
    }

    @GetMapping("/{customerId}")
    public List<Order> findByCustomer(@PathVariable int customerId){
        return repository.findByCustomerId(customerId);
    }

    @GetMapping("/order/{orderId}")
    public Optional<Order> findByOrderId(@PathVariable int orderId){
        return repository.findById(orderId);
    }

    @GetMapping("/findAll")
    public List<Order> findAll(){return repository.findAll();}

    @GetMapping("/about")
    public String about(){return "Jingwen Pang \n This is the website for order service";}
}