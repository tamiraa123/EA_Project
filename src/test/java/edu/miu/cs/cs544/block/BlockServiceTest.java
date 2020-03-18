package edu.miu.cs.cs544.enrollmentsystem.block;

import edu.miu.cs.cs544.domain.Block;
import edu.miu.cs.cs544.repository.BlockRepository;
import edu.miu.cs.cs544.service.BlockService;
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

import static org.mockito.Mockito.*;

@SpringBootTest
public class BlockServiceTest {
    List<Block> blockList=  Arrays.asList(
            new Block(1, "2020-02", "February 2020", "Summer", 2,
                    new SimpleDateFormat("yyyy-mm-dd").parse("2020-02-04"),
                    new SimpleDateFormat("yyyy-mm-dd").parse("2020-03-05")),
            new Block(2, "2020-03", "November 2020", "Spring", 1,
                    new SimpleDateFormat("yyyy-mm-dd").parse("2020-04-04"),
                    new SimpleDateFormat("yyyy-mm-dd").parse("2020-05-05")));
    @Mock
    private BlockRepository repository;

    @InjectMocks
    private BlockService blockService;

    public BlockServiceTest() throws ParseException {
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testGetBlock() throws Exception {
        when(repository.findById(Mockito.anyInt())).thenReturn(java.util.Optional.of(blockList.get(0)));
        Assertions.assertEquals(blockService.getBlock(1), blockList.get(0));
    }

    @Test
    public void testGetBlocks() throws  Exception {
        when(repository.findAll()).thenReturn(blockList);
        Assertions.assertEquals(blockService.getAllBlocks().size(), 2);
    }

    @Test
    public void testAddBlock() throws Exception {
        when(repository.save(blockList.get(0))).thenReturn(blockList.get(0));
        Assertions.assertEquals(blockList.get(0), blockService.addBlock(blockList.get(0)));
    }

    @Test
    public void testDeleteBlock() throws Exception {
        blockService.deleteBlock(1);
        verify(repository, times(1)).deleteById(1);
    }

}
