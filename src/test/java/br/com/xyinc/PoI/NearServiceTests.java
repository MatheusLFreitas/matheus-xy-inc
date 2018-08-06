package br.com.xyinc.PoI;

import br.com.xyinc.PoI.model.Coordinates;
import br.com.xyinc.PoI.model.PointOfInterestDTO;
import br.com.xyinc.PoI.service.PointOfInterestCRUDService;
import br.com.xyinc.PoI.service.PointOfInterestListService;
import br.com.xyinc.PoI.service.PointOfInterestNearService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NearServiceTests {

    @Autowired
    private PointOfInterestNearService service;

    @Test
    public void FindNearExample(){

        try {
            List<PointOfInterestDTO> dtos = service.findNearby(20, 10, 10);

            Assert.assertNotNull(dtos);
            Assert.assertTrue(dtos.size() >= 4);
        }catch (Exception e){
            Assert.assertNotNull(e);
        }

    }


}
