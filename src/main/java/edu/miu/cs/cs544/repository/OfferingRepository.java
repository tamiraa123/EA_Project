package edu.miu.cs.cs544.repository;


import edu.miu.cs.cs544.domain.Offering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferingRepository  extends JpaRepository<Offering, Long> {

       // @Query("select o,s,f,b,c,e,ss from Offering o join o.sections s join s.faculty f join o.blocks b join o.courses c join s.enrollmentRecords e join e.student ss")
       // List<Object> findByAuthorAndTitle();

}
