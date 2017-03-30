package api.coffee.service;


import api.coffee.model.Order;
import api.coffee.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    
    public Order placeOrder(Order order) {
        UUID id = UUID.randomUUID();
        order.setId(id);
        orderRepository.save(order);
        return order;
    }

    public List<Order> findAll() {
       return orderRepository.findAll();
    }

    public Order findOne(UUID id) {
       return orderRepository.findOne(id);
    }

    public void delete(UUID id) {
        orderRepository.delete(id);
    }
}
