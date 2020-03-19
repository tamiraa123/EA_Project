package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.domain.Faculty;
import edu.miu.cs.cs544.domain.Person;
import edu.miu.cs.cs544.domain.Student;
import edu.miu.cs.cs544.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    PersonService studentService;

    @RequestMapping(value="/add",method = RequestMethod.POST)
    public String addStudent(@RequestBody Student student) {
        studentService.addFaculty(student);
        return "Success";
    }
    @RequestMapping(value="/remove/{id}", method = RequestMethod.GET)
    public String removeStudent(@PathVariable int id){
        studentService.removeFaculty(id);
        return "Success";
    }
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editFaculty(@RequestBody Student student){
        studentService.editFaculty(student);
        return "Success";
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Person getStudent(@PathVariable int id){
        return studentService.getFaculty(id);
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public List<Person> getStudentList(){
        return studentService.getFacultyList();
    }
}
