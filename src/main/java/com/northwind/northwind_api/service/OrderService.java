package com.northwind.northwind_api.service;

import com.northwind.northwind_api.model.Order;
import com.northwind.northwind_api.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(long id) {
        return orderRepository.findById(id);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Optional<Order> updateOrder(long id, Order order) {
        if (orderRepository.existsById(id)) {
            order.setId(id);
            return Optional.of(orderRepository.save(order));
        } else {
            return Optional.empty();
        }
    }

    public void deleteOrderById(long id) {
        orderRepository.deleteById(id);
    }

    public List<Order> getOrdersByCustomerId(long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    public List<Order> getOrdersByEmployeeId(long employeeId) {
        return orderRepository.findByEmployeeId(employeeId);
    }
}
