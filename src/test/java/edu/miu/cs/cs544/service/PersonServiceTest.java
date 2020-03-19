package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Person;
import edu.miu.cs.cs544.repository.EntryRepository;
import edu.miu.cs.cs544.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class PersonServiceTest {

    List<Person> personList= Arrays.asList(new Person("Sergelen","Enkhee","Caleb","123","PROF")
    ,new Person("Seka","Enkhee","Caleb","123","PROF"));

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;
    
    @Test
    void getPerson() {
        when(personRepository.findById(Mockito.anyInt())).thenReturn(java.util.Optional.of(personList.get(0)));
        Assertions.assertEquals(personService.getPerson(1), personList.get(0));
    }

    @Test
    void getFacultyList() {
        when(personRepository.findAll()).thenReturn(personList);
        Assertions.assertEquals(personService.getFacultyList().size(), 2);
    }
}