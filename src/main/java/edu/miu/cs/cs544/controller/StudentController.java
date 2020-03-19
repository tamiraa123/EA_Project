package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.domain.Entry;
import edu.miu.cs.cs544.domain.Person;
import edu.miu.cs.cs544.domain.Student;
import edu.miu.cs.cs544.service.EntryService;
import edu.miu.cs.cs544.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    PersonService studentService;

    @Autowired
    EntryService entryService;

    @RequestMapping(value="/{eId}",method = RequestMethod.POST)
    public String addStudent(@RequestBody Student student, @PathVariable int eId) {
        Entry entry = entryService.getEntry(eId);
        student.setEntry(entry);
        studentService.addPerson(student);
        return "Success";
    }

    @RequestMapping(value="/", method = RequestMethod.DELETE)
    public String removeStudent(@RequestBody Student student){
        return studentService.removePerson(student.getId());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String editStudent(@RequestBody Student student, @PathVariable int id){
        return studentService.editPerson(student,id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person getStudent(@PathVariable int id){
        return studentService.getPerson(id);
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public List<Person> getStudentList(){

        List<Person> students = new ArrayList<>();
        List<Person> list = studentService.getFacultyList();

        for(Person student: list){
            if(student.getRole().equals("STU")){
                students.add(student);
            }
        }

        return students;
    }
}