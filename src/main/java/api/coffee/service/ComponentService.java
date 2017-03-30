package api.coffee.service;

import api.coffee.model.Coffee;
import api.coffee.model.ExtraComponent;
import api.coffee.model.Order;
import api.coffee.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.UUID;


@Component
public class ComponentService {

    @Autowired
    OrderRepository orderRepository;
    public UUID adComponent(UUID id, UUID cId, ExtraComponent extracomponent) {
        Order order = orderRepository.findOne(id);
        UUID eid = UUID.randomUUID();
        extracomponent.setId(eid);
        order.getCoffeeList().forEach(coffee -> {
            if (coffee.getId().equals(cId)){
                coffee.getComponents().add(extracomponent);
            }
        });
        orderRepository.save(order);
        return extracomponent.getId();
    }

    public ArrayList<ExtraComponent> getAllComponents(UUID id, UUID cId) {
        Order order = orderRepository.findOne(id);
        return order.getCoffeeList()
                .stream()
                .filter(coffee -> coffee.getId().equals(cId))
                .findFirst().orElse(null).getComponents();
    }

    public void cancelComponent(UUID id, UUID cId, UUID eId) {
        Order order = orderRepository.findOne(id);
        ArrayList<Coffee> coffees = order.getCoffeeList();
        coffees.forEach( coffee -> {
            if (coffee.getId().equals(cId)){
                deleteComponent(coffee,eId);
            }
        });
        orderRepository.save(order);
    }

    private void deleteComponent(Coffee coffee, UUID eId){
        ArrayList<ExtraComponent> componentList= coffee.getComponents();
        componentList.removeIf(component -> (component.getId().equals(eId)));
    }
}
