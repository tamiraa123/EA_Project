package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.domain.Block;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockRepository extends JpaRepository<Block, Long> {
}
