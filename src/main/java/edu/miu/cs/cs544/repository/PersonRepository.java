package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PersonRepository extends JpaRepository<Person, Integer> {
}