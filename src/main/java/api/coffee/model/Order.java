package api.coffee.model;

import java.util.ArrayList;
import java.util.UUID;

public class Order {

    {
        this.coffeeList = new ArrayList<>();
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    private UUID id;

    public void setCoffeeList(ArrayList<Coffee> coffeeList) {
        this.coffeeList = coffeeList;
    }

    private ArrayList<Coffee> coffeeList;

    public ArrayList<Coffee> getCoffeeList() {
        return coffeeList;
    }
}
