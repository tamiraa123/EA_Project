package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.domain.Faculty;
import edu.miu.cs.cs544.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    FacultyService facultyService;

    @RequestMapping(value="/add",method = RequestMethod.POST)
    public String addFaculty(Faculty faculty) {
        facultyService.addFaculty(faculty);
        return "Success"; }
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removeFaculty(@PathVariable int id) {
        facultyService.removeFaculty(id);
        return "Success";
    }
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editFaculty(Faculty faculty){
        facultyService.editFaculty(faculty);
        return "Success";
    }
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public String getFaculty(@PathVariable int id){
        facultyService.getFaculty(id);
        return "Success";
    }
        @RequestMapping(value = "/", method = RequestMethod.GET)
        public List<Faculty> getFacultyList(){
            return facultyService.getFacultyList();
        }
}