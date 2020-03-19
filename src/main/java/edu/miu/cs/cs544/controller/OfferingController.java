package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.domain.Block;
import edu.miu.cs.cs544.domain.Course;
import edu.miu.cs.cs544.domain.Offering;
import edu.miu.cs.cs544.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping(value="offering")
public class OfferingController {
    @Autowired
    private OfferingService offeringService;
    @Autowired
    private BlockService blockService;
    @Autowired
    private CourseServiceImpl courseService;
    @Autowired
    private SectionService sectionService;


    @RequestMapping("/offering/test")
    public String testOffeirng() {
        return "Offering is working";
    }

    @PostMapping("/offering/{bId}/{cId}")
    public Offering register ( @PathVariable int bId, @PathVariable int cId) {

        Course c = courseService.get(cId).get();
        Block b = blockService.getBlock(bId);
        Offering offering  = new Offering();
        offering.setCourse(c);
        offering.setBlock(b);
        offering.setCode(c.getName() + "-" + b.getCode());
        return offeringService.addOffering(offering);
    }

    @PutMapping("/offering/{offeringId}/block/{blockId}/course/{courseId}")
    public String editOfferingBlock(@PathVariable int blockId, @PathVariable int offeringId, @PathVariable int courseId){

        Offering o = offeringService.getOffer(offeringId);
        o.setBlock(blockService.getBlock(blockId));
        o.setCourse(courseService.get(courseId).get());
        offeringService.addOffering(o);
        return "Success";
    }

    @DeleteMapping("/offering/{offeringId}")
    public String deleteOffer(@PathVariable int offeringId) {
        offeringService.deleteOffering(offeringId);
        return "Delete is Success";
    }

    @GetMapping("/offering/{offeringId}")
    public Offering getOffer(@PathVariable int offeringId) {
        return offeringService.getOffer(offeringId);
    }

    @GetMapping("/offerings")
    public List<Offering> getOffers() {
        return offeringService.getOfferings();
    }


}


