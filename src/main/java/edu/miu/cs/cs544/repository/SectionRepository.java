package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.domain.Offering;
import edu.miu.cs.cs544.domain.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository  extends JpaRepository<Section, Integer> {

}