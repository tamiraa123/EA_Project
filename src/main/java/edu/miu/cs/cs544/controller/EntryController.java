package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.domain.Entry;
import edu.miu.cs.cs544.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entry")
public class EntryController {

    @Autowired
    EntryService entryService;

    @RequestMapping(value="/",method = RequestMethod.POST)
    public String addEntry(@RequestBody Entry entry){
        entryService.addEntry(entry);
        return "SUCCESS";
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String editEntry(@RequestBody Entry entry,@PathVariable int id){
        return entryService.editEntry(entry,id);
    }
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public String removeEntry(@RequestBody Entry entry){
        return entryService.removeEntry(entry.getId());
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Entry getEntry(@PathVariable int id){
        return entryService.getEntry(id);
    }
    @RequestMapping(value = "/entries", method = RequestMethod.GET)
    public List<Entry> getEntryList(){
        return entryService.getEntryList();
    }

}
