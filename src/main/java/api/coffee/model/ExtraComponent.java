package api.coffee.model;

import java.util.UUID;

public class ExtraComponent {
    private UUID id;
    private String name;

    public UUID getId() {
        return id;
    }

    public ExtraComponent(String name){
        this.name = name;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
