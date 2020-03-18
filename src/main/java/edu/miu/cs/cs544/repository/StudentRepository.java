package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.domain.Offering;
import edu.miu.cs.cs544.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}

