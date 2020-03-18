package edu.miu.cs.cs544.repository;


import edu.miu.cs.cs544.domain.Enrollment;
import edu.miu.cs.cs544.domain.Offering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferingRepository  extends JpaRepository<Offering, Integer> {

}
