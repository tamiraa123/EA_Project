package edu.miu.cs.cs544.repository;
import edu.miu.cs.cs544.domain.Offering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferingRepository extends JpaRepository<Offering,Long> {


}
