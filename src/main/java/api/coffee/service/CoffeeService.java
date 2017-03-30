package api.coffee.service;


import api.coffee.model.Coffee;
import api.coffee.model.Order;
import api.coffee.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

@Component
public class CoffeeService {

    @Autowired
    OrderRepository orderRepository;

    public UUID addCoffee(UUID id, Coffee coffee) {
        Order order = orderRepository.findOne(id);
        UUID coffeeId = UUID.randomUUID();
        coffee.setId(coffeeId);
        order.getCoffeeList().add(coffee);
        orderRepository.save(order);
        return coffee.getId();
    }

    public ArrayList<Coffee> getAllCoffees(UUID id) {
        Order order = orderRepository.findOne(id);
        return order.getCoffeeList();
    }

    public Coffee getCoffee(UUID id, UUID cId) {
        Order order = orderRepository.findOne(id);
        return order.getCoffeeList()
                .stream()
                .filter(coffee -> coffee.getId().equals(cId))
                .findFirst()
                .orElse(null);
    }

    public void cancelCoffee(UUID id, UUID cId) {
        Order order = orderRepository.findOne(id);
        ArrayList<Coffee> coffees = order.getCoffeeList();
        coffees.removeIf(coffee -> (coffee.getId().equals(cId)));
        orderRepository.save(order);
    }
}
