package edu.miu.cs.cs544.controller;


import edu.miu.cs.cs544.domain.Enrollment;
import edu.miu.cs.cs544.domain.Offering;
import edu.miu.cs.cs544.domain.Section;
import edu.miu.cs.cs544.domain.Student;
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

    @RequestMapping(value="/getEnrollmentAdmin",method = RequestMethod.GET)
    public List<Enrollment>  getEnrollmentAdmin()
    {
        return offeringService.EnrollmentAdmin();
    }

    @RequestMapping(value="/getEnrollmentFaculty",method = RequestMethod.GET)
    public List<Enrollment>  getEnrollmentFaculty()
    {
        return offeringService.EnrollmentFaculty();
    }

    //Student
    @RequestMapping(value="/getEnrollmentStudent",method = RequestMethod.GET)
    public List<Enrollment>  getEnrollmentStudent()
    {
        return offeringService.EnrollmentStudent();
    }

    @RequestMapping(value="/enrollCourse",method = RequestMethod.POST)
    public void EnrollCourse(List<Section> sections, Student student)
    {

    }

}
