package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Block;
import edu.miu.cs.cs544.repository.BlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockService {
    @Autowired
    private BlockRepository blockRepository;

    public Block addBlock(Block block) {
        return blockRepository.save(block);
    }

    public Block getBlock(int blockId) {
        return blockRepository.findById(blockId).get();
    }

    public List<Block> getAllBlocks() {
        return blockRepository.findAll();
    }

    public Block editBlock(Block block, int blockId) {
           block.setId(blockId);
           return blockRepository.save(block);
    }

    public void deleteBlock(int blockId) {
        blockRepository.deleteById(blockId);
    }
}
