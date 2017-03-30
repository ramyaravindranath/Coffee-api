package api.coffee.controller;

import api.coffee.model.Order;
import api.coffee.repo.OrderRepository;
import api.coffee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/order", produces = {
        MediaType.APPLICATION_JSON_VALUE
})
public class OrderController {

    @Autowired
    private OrderService orderService;


    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Order placeOrder(@RequestBody Order order) {
        return orderService.placeOrder(order);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Order> getOrders(){
       return orderService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Order getOrder(@PathVariable UUID id) {
        return orderService.findOne(id);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void cancelOrder(@PathVariable UUID id){
        orderService.delete(id);
    }



}
