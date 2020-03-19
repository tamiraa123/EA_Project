package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.domain.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry,Integer> {
}
