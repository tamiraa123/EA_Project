package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Section;
import edu.miu.cs.cs544.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SectionService {
    @Autowired
    SectionRepository sectionRepository;
        public List<Section> getSections(){
        return sectionRepository.findAll();
    }
        public Section getSection(int id){
            if(sectionRepository.findById(id).isPresent()) {
                return sectionRepository.findById(id).get();
            }
            else{
                return null;
            }
        }
        public Section addSection(Section section){
            return sectionRepository.save(section);
        }
        public Section editSection(Section section,int id){
            section.setId(id);
            return sectionRepository.save(section);
        }
        public void removeSection(Section section){
            Optional<Section> deleteSection = sectionRepository.findById(section.getId());
            if (deleteSection.isPresent()) {
                sectionRepository.delete(deleteSection.get());
            }
        }
}
