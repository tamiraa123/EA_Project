package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Person;
import edu.miu.cs.cs544.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FacultyService {
    @Autowired
    PersonRepository personRepository;

    public void addFaculty(Person faculty){
        personRepository.save(faculty);
    }
    public void removeFaculty(int id){
        personRepository.deleteById(id);
    }
    public void editFaculty(Person faculty){ personRepository.save(faculty); }
    public void editFacultyWitId(Person faculty, Integer id){
        faculty.setId(id);
        personRepository.save(faculty);
    }
    public Person getFaculty(int id){
        return personRepository.findById(id).get();
    }
    public List<Person> getFacultyList(){
        return personRepository.findAll();
    }
}