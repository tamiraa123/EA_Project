package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.domain.Faculty;
import edu.miu.cs.cs544.domain.Person;
import edu.miu.cs.cs544.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    PersonService facultyService;

    private String countryCode;
    @RequestMapping(value="/add",method = RequestMethod.POST)
    public String addFaculty(@RequestBody Faculty faculty) {
        facultyService.addFaculty(faculty);
        return "Success"; }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removeFaculty(@PathVariable int id) {
        facultyService.removeFaculty(id);
        return "Success";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editFaculty(@RequestBody Faculty faculty){
        facultyService.editFaculty(faculty);
        return "Success";
    }

    @RequestMapping(value = "/edit_with_id/",params = "id", method = RequestMethod.POST)
    public String editFaculty(@RequestBody Faculty faculty, @RequestParam int id){
        facultyService.editFacultyWitId(faculty,id);
        return "Success";
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Person getFaculty(@PathVariable int id){
        return facultyService.getFaculty(id);
    }

    @RequestMapping(value = "/faculties", method = RequestMethod.GET)
    public List<Person> getFacultyList(){
        return facultyService.getFacultyList();
    }
}