package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.domain.Block;
import edu.miu.cs.cs544.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

public class BlockController {
    @Autowired
    private BlockService blockService;

    @RequestMapping(value = "/blocks/{id}", method = RequestMethod.POST)
    public void createBlock(@Valid @RequestBody Block block) {
        blockService.addBlock(block);
    }

    @RequestMapping(value = "/blocks/{id}", method = RequestMethod.POST)
    public Block editBlock(@Valid @RequestBody Block block, @PathVariable Long id) {
        return blockService.editBlock(block, id);
    }

    @RequestMapping(value = "/blocks/{id}", method = RequestMethod.GET)
    public Block getBlock(@PathVariable Long id) {
        return blockService.getBlock(id);
    }

    @RequestMapping(value = "/blocks/", method = RequestMethod.GET)
    public List<Block> getBlocks(){
        return blockService.getAllBlocks();
    }

    @RequestMapping(value = "/blocks/{id}", method = RequestMethod.POST)
    public void deleteBlock(@PathVariable Long id) {
        blockService.deleteBlock(id);
    }
}
