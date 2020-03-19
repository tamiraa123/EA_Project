package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.domain.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface BlockRepository extends JpaRepository<Block, Integer> {
    public List<Block> getBlocksByCode(String code);
    public List<Block> getBlocksByName(String name);
    public List<Block> getBlocksBySemester(String semester);
}
