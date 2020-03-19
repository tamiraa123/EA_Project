package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Entry;
import edu.miu.cs.cs544.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EntryService {

    @Autowired
    EntryRepository entryRepository;

    public void addEntry(Entry entry){
        entryRepository.save(entry);
    }

    public String editEntry(Entry entry, int id){
        if(entryRepository.findById(id).isPresent()){
            entry.setId(id);
            entryRepository.save(entry);
            return "SUCCESS";
        }
        return "VALUE IS NOT FOUND";
    }

    public String removeEntry(int id){
        if(entryRepository.findById(id).isPresent()){
            entryRepository.deleteById(id);
            return "SUCCESS";
        }
        return "VALUE IS NOT FOUND";
    }

    public Entry getEntry(int id){
        if(entryRepository.findById(id).isPresent()){
            return entryRepository.findById(id).get();
        }
        return null;
    }

    public List<Entry> getEntryList(){
        return entryRepository.findAll();
    }

}
