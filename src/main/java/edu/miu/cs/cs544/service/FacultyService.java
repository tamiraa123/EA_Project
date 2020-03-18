package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Faculty;
import edu.miu.cs.cs544.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class FacultyService {
    @Autowired
    FacultyRepository facultyRepository;
    public void addFaculty(Faculty faculty){
        facultyRepository.save(faculty);
    }
    public void removeFaculty(int id){
        facultyRepository.deleteById(id);
    }
    public void editFaculty(Faculty faculty){
        facultyRepository.save(faculty);
        // what if?
//        Faculty newFac = facultyRepository.getOne(Long.valueOf(faculty.getId()));
//
//        if(newFac != null){
//            newFac.setTitle(faculty.getTitle());
//        }
    }
    public Faculty getFaculty(int id){
        return facultyRepository.getOne(id);
    }

    public List<Faculty> getFacultyList(){
        return facultyRepository.findAll();
    }
}