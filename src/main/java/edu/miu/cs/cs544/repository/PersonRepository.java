package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD:src/main/java/edu/miu/cs/cs544/repository/FacultyRepository.java
import org.springframework.stereotype.Repository;

@Repository

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
=======
public interface PersonRepository extends JpaRepository<Person, Integer> {
>>>>>>> upstream/master:src/main/java/edu/miu/cs/cs544/repository/PersonRepository.java
}