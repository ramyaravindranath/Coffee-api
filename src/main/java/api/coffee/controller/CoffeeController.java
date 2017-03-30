package api.coffee.controller;

import api.coffee.model.Coffee;
import api.coffee.model.Order;
import api.coffee.repo.OrderRepository;
import api.coffee.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;


@RestController
@RequestMapping("/order/{id}/coffee")
public class CoffeeController {

    @Autowired
    CoffeeService coffeeService;

    @RequestMapping(method = RequestMethod.POST)
    public UUID addCoffee(@PathVariable UUID id, @RequestBody Coffee coffee){
        return coffeeService.addCoffee(id, coffee);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ArrayList<Coffee> getAllCoffees(@PathVariable UUID id){
        return coffeeService.getAllCoffees(id);
    }

    @RequestMapping(value = "/{cId}", method = RequestMethod.GET)
    public Coffee getCoffee(@PathVariable UUID id, @PathVariable UUID cId){
        return coffeeService.getCoffee(id,cId);
    }


    @RequestMapping(value = "/{cId}", method = RequestMethod.DELETE)
    public void cancelCoffee(@PathVariable UUID id, @PathVariable UUID cId) {
        coffeeService.cancelCoffee(id,cId);
    }

}
