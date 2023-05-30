package com.laporrasm.orders;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return new ResponseEntity<>(orderService.allOrders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Order>> getSingleOrder(@PathVariable String id) {
        return new ResponseEntity<>(orderService.singleOrder(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Order> postOrder(@RequestBody Order order) {
        return new ResponseEntity<>(orderService.setOrder(order), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable String id) {
        orderService.removeOrder(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
