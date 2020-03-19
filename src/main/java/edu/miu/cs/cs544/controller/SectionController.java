package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.domain.Enrollment;
import edu.miu.cs.cs544.domain.Section;
import edu.miu.cs.cs544.service.EnrollmentRecordService;
import edu.miu.cs.cs544.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sections")
public class SectionController {
    @Autowired
    SectionService sectionService;

    //Section
    @RequestMapping(value="/",method = RequestMethod.GET)
    public List<Section> getSections()
    {
       return sectionService.getSections();
    }
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Section getSection(@PathVariable int id){
        return sectionService.getSection(id);
    }
    @RequestMapping(value="",method = RequestMethod.POST)
    public void addSection(@RequestBody Section section)
    {
        sectionService.addSection(section);
    }
    @RequestMapping(value="/{id}",method = RequestMethod.PATCH)
    public void editSection(@RequestBody Section section,@PathVariable int id)
    {
        sectionService.editSection(section,id);
    }
    @RequestMapping(value="/",method = RequestMethod.DELETE)
    public void getEnrollmentAdmin(@RequestBody Section section)
    {
        sectionService.removeSection(section);
    }
}
