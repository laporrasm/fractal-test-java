package com.laporrasm.orders;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    public List<Order> allOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> singleOrder(String id) {
        return orderRepository.findById(id);
    }

    public Order setOrder(Order orderToSet) {
        Order order = orderRepository.save(orderToSet);
        return order;
    }

    public void removeOrder(String id) {
        orderRepository.deleteById(id);
    }
}
