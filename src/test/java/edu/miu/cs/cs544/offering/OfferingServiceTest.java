package edu.miu.cs.cs544.offering;

import edu.miu.cs.cs544.domain.Block;
import edu.miu.cs.cs544.domain.Course;
import edu.miu.cs.cs544.domain.Offering;
import edu.miu.cs.cs544.repository.OfferingRepository;
import edu.miu.cs.cs544.service.OfferingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
public class OfferingServiceTest {
    @Mock
    private OfferingRepository offeringRepository;
    @InjectMocks
    private OfferingService offeringService;

    public OfferingServiceTest() throws ParseException {

    }
    List<Block> blockList=  Arrays.asList(
            new Block(1, "2020-02", "February 2020", "Summer", 2,
                    new SimpleDateFormat("yyyy-mm-dd").parse("2020-02-04"),
                    new SimpleDateFormat("yyyy-mm-dd").parse("2020-03-05")),
            new Block(2, "2020-03", "November 2020", "Spring", 1,
                    new SimpleDateFormat("yyyy-mm-dd").parse("2020-04-04"),
                    new SimpleDateFormat("yyyy-mm-dd").parse("2020-05-05")));
     List<Course>  courseList = Arrays.asList(
            new Course("CS544", "EA", "Enterprise Architecture"),
            new Course("CS422", "MPP", "Modern Programming Practices"),
            new Course("CS390", "FPP", "Fundamentals of Programming Practices")
    );

    List<Offering> offerList=  Arrays.asList(
            new Offering(1,"",courseList.get(0), blockList.get(0)),
            new Offering(2,"",courseList.get(1), blockList.get(1))

            );

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testGetOffer() throws Exception {
        when(offeringRepository.findById(Mockito.anyInt())).thenReturn(java.util.Optional.of(offerList.get(0)));
        Assertions.assertEquals(offeringService.getOffer(0), offerList.get(0));
    }

    @Test
    public void testGetOffers() throws  Exception {
        when(offeringRepository.findAll()).thenReturn(offerList);
        Assertions.assertEquals(offeringService.getOfferings().size(), 2);
    }
    @Test
    public void testAddOffer() throws Exception {
        when(offeringRepository.save(offerList.get(0))).thenReturn(offerList.get(0));
        Assertions.assertEquals(offerList.get(0),offeringService.addOffering(offerList.get(0)));
    }
    @Test
    public void testDeleteOffering() throws Exception {
        when(offeringRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(offerList.get(0)));
        offeringService.deleteOffering(1);
        verify(offeringRepository, times(1)).delete(offerList.get(0));
    }
}

