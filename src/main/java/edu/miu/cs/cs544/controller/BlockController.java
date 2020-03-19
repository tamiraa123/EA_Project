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

    @GetMapping("/block/{id}")
    public Block getBlock(@PathVariable int id) {
        return blockService.getBlock(id);
    }

    @GetMapping("/blocks")
    public List<Block> getAllBlocks(){
        return blockService.getAllBlocks();
    }

//    @GetMapping("/block/{blockName}")
//    public Block getBlocksByName(@PathVariable String blockName) {
//        return blockService.getBlocksByName(blockName);
//    }
//
//    @GetMapping("/blocks/{blockCode}")
//    public List<Block> getBlocksByCode(@PathVariable String blockCode) {
//        return blockService.getBlocksByCode(blockCode);
//    }

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
