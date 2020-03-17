package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.domain.Block;
import edu.miu.cs.cs544.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class BlockController {
    @Autowired
    private BlockService blockService;

    @GetMapping("/blocks/{id}")
    public Block getBlock(@PathVariable Long id) {
        return blockService.getBlock(id);
    }

    @GetMapping("/blocks")
    public List<Block> getBlocks(){
        return blockService.getAllBlocks();
    }

    @PostMapping("/blocks")
    public void createBlock(@Valid @RequestBody Block block) {
        blockService.addBlock(block);
    }

    @PutMapping("/blocks/{id}")
    public Block editBlock(@Valid @RequestBody Block block, @PathVariable Long blockId) {
        return blockService.editBlock(block, blockId);
    }

    @DeleteMapping("/blocks/{id}")
    public void deleteBlock(@PathVariable Long id) {
        blockService.deleteBlock(id);
    }
}
