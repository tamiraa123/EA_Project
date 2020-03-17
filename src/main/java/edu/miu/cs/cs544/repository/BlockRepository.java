package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.domain.Block;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlockRepository extends JpaRepository<Block, Integer> {
    public List<Block> getBlocksByCode(String code);
    public List<Block> getBlocksByName(String name);
    public List<Block> getBlocksBySemester(String semester);
}
