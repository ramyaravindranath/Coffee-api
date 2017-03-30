package api.coffee.model;


import java.util.ArrayList;
import java.util.UUID;

public class Coffee {

    private UUID id;

    private String type;

    public Coffee(String type){

        this.type = type;
        this.components = new ArrayList<ExtraComponent>();

    }

    public Coffee(){

    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private ArrayList<ExtraComponent> components;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ArrayList<ExtraComponent> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<ExtraComponent> components) {
        this.components = components;
    }
}
