package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.domain.Enrollment;
import edu.miu.cs.cs544.domain.Section;
import edu.miu.cs.cs544.service.EnrollmentRecordService;
import edu.miu.cs.cs544.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/section")
public class SectionController {
    @Autowired
    SectionService sectionService;

    //Section
    @RequestMapping(value="/sections",method = RequestMethod.POST)
    public void getSection()
    {
        sectionService.getSection();
    }
    @RequestMapping(value="/add",method = RequestMethod.POST)
    public void addSection(@RequestBody Section section)
    {
        sectionService.addSection(section);
    }
    @RequestMapping(value="/edit",method = RequestMethod.POST)
    public void editSection(@RequestBody Section section)
    {
        sectionService.addSection(section);
    }

    @RequestMapping(value="/delete",method = RequestMethod.DELETE)
    public void getEnrollmentAdmin(@RequestBody Section section)
    {
        sectionService.removeSection(section);
    }
}
