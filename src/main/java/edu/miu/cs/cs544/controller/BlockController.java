package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.domain.Block;
import edu.miu.cs.cs544.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BlockController {
    @Autowired
    private BlockService blockService;

    @GetMapping("/block/{id}")
    public Block getBlock(@PathVariable int id) {
        return blockService.getBlock(id);
    }

    @GetMapping("/blocks")
    public List<Block> getBlocks(){
        return blockService.getAllBlocks();
    }

    @PostMapping("/block")
    public Block createBlock(@Valid @RequestBody Block block) {
        return blockService.addBlock(block);
    }

    @PutMapping(value = "/block/{blockId}")
    public Block editBlock(@Valid @RequestBody Block block, @PathVariable int blockId) {
        return blockService.editBlock(block, blockId);
    }

    @DeleteMapping("/block/{blockId}")
    public String deleteBlock(@PathVariable int blockId) {
        blockService.deleteBlock(blockId);
        return "Successfully deleted";
    }
}
