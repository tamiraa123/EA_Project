package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.domain.Offering;
import edu.miu.cs.cs544.service.OfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerOffering {

    @Autowired
    private OfferingService offeringService;

    @RequestMapping(path= "/offering", method = RequestMethod.POST)
  public  Offering register (@RequestBody Offering offering) {
        return offeringService.saveOffring(offering);
    }

}
