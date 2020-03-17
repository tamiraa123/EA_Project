package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.domain.EnrollmentRecord;
import edu.miu.cs.cs544.domain.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRecordRepository extends JpaRepository<EnrollmentRecord, Integer> {
}
