package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Section;
import edu.miu.cs.cs544.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SectionService {
    @Autowired
    SectionRepository sectionRepository;
        public List<Section> getSection(){
        return sectionRepository.findAll();
    }
        public Section addSection(Section section){
            return sectionRepository.save(section);
        }
        public Section editSection(Section section){
            return sectionRepository.save(section);
        }
        public void removeSection(Section section){
             sectionRepository.delete(section);
        }
}
