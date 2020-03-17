package edu.miu.cs.cs544.controller;


import edu.miu.cs.cs544.service.OfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="offering")
public class OfferingController {
    @Autowired
    OfferingService offeringService;

    @RequestMapping(value="/getEnrollmentView",method = RequestMethod.GET)
    public List<Object> getEnrollmentView()
    {
       return offeringService.EnrollmentView();
    }


}
