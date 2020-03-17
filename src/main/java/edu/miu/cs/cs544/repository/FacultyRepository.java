package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.domain.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
}