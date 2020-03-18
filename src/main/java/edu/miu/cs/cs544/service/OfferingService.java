package edu.miu.cs.cs544.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferingService {
    @Autowired
    OfferingService offeringService;

    public List<Object> EnrollmentView()
    {
        return offeringService.EnrollmentView();
    }
}
