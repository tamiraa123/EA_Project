package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Entry;
import edu.miu.cs.cs544.repository.EntryRepository;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class EntryServiceTest {
@Mock
private EntryRepository entryRepository;

@InjectMocks
private EntryService entryService;

    List<Entry> entryList = Arrays.asList(
             new Entry(1,"MAY", new SimpleDateFormat("yyyy-mm-dd").parse("2020-04-04"), new SimpleDateFormat("yyyy-mm-dd").parse("2020-04-04"), new SimpleDateFormat("yyyy-mm-dd").parse("2020-04-04"))
            ,new Entry(2,"AUG",new SimpleDateFormat("yyyy-mm-dd").parse("2020-04-04"),new SimpleDateFormat("yyyy-mm-dd").parse("2020-04-04"),new SimpleDateFormat("yyyy-mm-dd").parse("2020-04-04")));

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    public EntryServiceTest() throws ParseException{

    }

//    @Test
//    void addEntry() throws Exception {
//        when(entryRepository.save(entryList.get(0))).thenReturn(entryList.get(0));
//        Assertions.assertEquals(entryList.get(0), entryService.getEntry(0));
//    }

    @Test
    void removeEntry() {
        entryService.removeEntry(1);
        verify(entryRepository, times(1)).deleteById(1);
    }

    @Test
    void getEntry() {
        when(entryRepository.findById(Mockito.anyInt())).thenReturn(java.util.Optional.of(entryList.get(0)));
        Assertions.assertEquals(entryService.getEntry(1), entryList.get(0));
    }

    @Test
    void getEntryList() {
        when(entryRepository.findAll()).thenReturn(entryList);
        Assertions.assertEquals(entryService.getEntryList().size(), 2);
    }
}