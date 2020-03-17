package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Offering;
import edu.miu.cs.cs544.repository.OfferingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class OfferingService {

    @Autowired
    private OfferingRepository offeringRepository;
private Offering offering;
    public Offering saveOffring(Offering offering){
        return offeringRepository.save(offering);

    }
    public void deleteOffering(Long id){
        offeringRepository.deleteById(id);

    }
    public Offering findOne(Long id) {
        Optional<Offering> offerins = offeringRepository.findById(id);
        return offerins.orElse(null);
    }
    public List<Offering> findAll() {
        return (List<Offering>) offeringRepository.findAll();
    }
 public Offering editOffering(Offering offering){
        return offering;
        
 }
}
