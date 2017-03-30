package api.coffee.controller;

import api.coffee.model.ExtraComponent;
import api.coffee.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/order/{id}/coffee/{cId}/extra")
public class ComponentController {

    @Autowired
    ComponentService componentService;

    @RequestMapping(method = RequestMethod.POST)
    public UUID addComponent(@PathVariable UUID id, @PathVariable UUID cId, @RequestBody ExtraComponent component){
       return componentService.adComponent(id,cId,component);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ArrayList<ExtraComponent> getAllComponents(@PathVariable UUID id,
                                                      @PathVariable UUID cId){
        return componentService.getAllComponents(id,cId);
    }


    @RequestMapping(value = "/{eId}", method = RequestMethod.DELETE)
    public void cancelComponent(@PathVariable UUID id,
                             @PathVariable UUID cId,
                             @PathVariable UUID eId) {
         componentService.cancelComponent(id,cId, eId);
    }
}
