package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Person;
import edu.miu.cs.cs544.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public void addPerson(Person person){
        personRepository.save(person);
    }
    public String removePerson(int id){
        if(personRepository.findById(id).isPresent()) {
            personRepository.deleteById(id);
            return "SUCCESS";
        }else{
            return "VALUE IS NOT FOUND";
        }
    }
    public String editPerson(Person person, Integer id){

        if(personRepository.findById(id).isPresent()){
            person.setId(id);
            personRepository.save(person);
            return "SUCCESS";
        }else {
            return "VALUE IS NOT FOUND";
        }

    }
    public Person getPerson(int id){
        if(personRepository.findById(id).isPresent()) {
            return personRepository.findById(id).get();
        }
        return null;
    }

    public List<Person> getFacultyList(){ return personRepository.findAll(); }
}