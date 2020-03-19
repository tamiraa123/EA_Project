package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.domain.Faculty;
import edu.miu.cs.cs544.domain.Person;
import edu.miu.cs.cs544.domain.Section;
import edu.miu.cs.cs544.domain.Student;
import edu.miu.cs.cs544.repository.SectionRepository;
import edu.miu.cs.cs544.service.PersonService;
import edu.miu.cs.cs544.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    PersonService facultyService;

    @Autowired
    SectionService sectionService;

    @RequestMapping(value="/{id}", method = RequestMethod.POST)
    public String addFaculty(@RequestBody Faculty faculty,@PathVariable int id) {
        Section section = sectionService.getSection(id);

        Faculty fac = new Faculty(faculty.getFirstName(),faculty.getLastName(),
                faculty.getUserName(),faculty.getPassword(),faculty.getRole(),faculty.getTitle());
        fac.setSection(section);
        facultyService.addPerson(fac);
        return "Success";
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public String removeFaculty(@RequestBody Faculty faculty) {
        return facultyService.removePerson(faculty.getId());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String editFaculty(@RequestBody Faculty faculty, @PathVariable int id){
        Faculty fac = new Faculty(faculty.getFirstName(),faculty.getLastName(),
                faculty.getUserName(),faculty.getPassword(),faculty.getRole(),faculty.getTitle());
            return facultyService.editPerson(fac,id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person getFaculty(@PathVariable int id){
        return facultyService.getPerson(id);
    }

    @RequestMapping(value = "/faculties", method = RequestMethod.GET)
    public List<Person> getFacultyList(){

        List<Person> faculties = new ArrayList<>();
        List<Person> list = facultyService.getFacultyList();

        for(Person faculty: list){
                if(faculty.getRole().equals("ROLE_FACULTY") && list != null){
                    faculties.add(faculty);
                }
        }

        return faculties;
    }
}