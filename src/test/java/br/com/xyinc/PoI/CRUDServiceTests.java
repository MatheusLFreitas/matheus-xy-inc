package br.com.xyinc.PoI;

import br.com.xyinc.PoI.model.Coordinates;
import br.com.xyinc.PoI.model.PointOfInterestDTO;
import br.com.xyinc.PoI.service.PointOfInterestCRUDService;
import br.com.xyinc.PoI.service.PointOfInterestListService;
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
public class CRUDServiceTests {

    @Autowired
    private PointOfInterestCRUDService service;

    @Autowired
    private PointOfInterestListService listService;

    @Test
    public void CreatePointOfInterest(){

        PointOfInterestDTO point = service.create(new PointOfInterestDTO("Teste", new Coordinates(15, 12)));

        Assert.assertNotNull(point);
        Assert.assertNotNull(point.getDocId());
        Assert.assertTrue(!point.getDocId().isEmpty());
    }

    @Test
    public void UpdatePointOfInterest(){

        List<PointOfInterestDTO> all = listService.findAll();

        Assert.assertTrue(all.size() > 0);

        PointOfInterestDTO point = all.get(0);

        String newName = "TESTES2";

        point.setName(newName);

        Optional<PointOfInterestDTO> updated = service.update(point);

        Assert.assertTrue(updated.isPresent());
        Assert.assertTrue(!updated.get().getDocId().isEmpty());
        Assert.assertTrue(!updated.get().getDocId().equals(point.getDocId()));
        Assert.assertTrue(!updated.get().getName().equals(newName));
    }

    @Test
    public void DeletePointOfInterest(){
        List<PointOfInterestDTO> all = listService.findAll();

        Assert.assertTrue(all.size() > 0);

        PointOfInterestDTO point = all.get(0);

        String newName = "TESTES2";

        Optional<PointOfInterestDTO> deleted = service.delete(point.getDocId());

        Assert.assertTrue(deleted.isPresent());
        Assert.assertTrue(!deleted.get().getDocId().isEmpty());
        Assert.assertTrue(!deleted.get().getDocId().equals(point.getDocId()));
    }

}
