package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.domain.Block;
import edu.miu.cs.cs544.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BlockController {
    @Autowired
    private BlockService blockService;

    @GetMapping("/blocks/{id}")
    public Block getBlock(@PathVariable int id) {
        return blockService.getBlock(id);
    }

    @GetMapping(value = "/blocks/",params = "blockId")
    public Block getBlock2(@RequestParam int blockId) {
        return blockService.getBlock(blockId);
    }

    @GetMapping("/blocks")
    public List<Block> getBlocks(){
        return blockService.getAllBlocks();
    }

    @PostMapping("/blocks")
    public void createBlock(@Valid @RequestBody Block block) {
        blockService.addBlock(block);
    }

    @PutMapping(value = "/blocks/", params = "blockId")
    public Block editBlock(@Valid @RequestBody Block block, @RequestParam int blockId) {
        return blockService.editBlock(block, blockId);
    }

    @DeleteMapping(value = "/blocks/", params = "blockId")
    public void deleteBlock(@RequestParam int blockId) {
        blockService.deleteBlock(blockId);
    }
}
