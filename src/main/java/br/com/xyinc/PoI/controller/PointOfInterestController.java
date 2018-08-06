package br.com.xyinc.PoI.controller;

import br.com.xyinc.PoI.model.PointOfInterestDTO;
import br.com.xyinc.PoI.service.PointOfInterestCRUDService;
import br.com.xyinc.PoI.service.PointOfInterestListService;
import br.com.xyinc.PoI.service.PointOfInterestNearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//TODO: Adicionar /api
@RequestMapping("/poi")
public class PointOfInterestController {

    private final PointOfInterestCRUDService crudService;
    private final PointOfInterestListService listService;
    private final PointOfInterestNearService nearService;

    @Autowired
    public PointOfInterestController (PointOfInterestCRUDService crudService,
                                     PointOfInterestListService listService,
                                     PointOfInterestNearService nearService) {
        this.crudService = crudService;
        this.listService = listService;
        this.nearService = nearService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    PointOfInterestDTO create(@RequestBody PointOfInterestDTO source){
        return crudService.create(source);
    }

    @RequestMapping(value = "{Id}", method = RequestMethod.PUT)
    @ResponseBody
    ResponseEntity<PointOfInterestDTO> update(@PathVariable String Id, @RequestBody PointOfInterestDTO source){

        source.setDocId(Id);

        Optional<PointOfInterestDTO> found = crudService.update(source);

        if(found.isPresent()){
            return ResponseEntity.ok(found.get());
        }

        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "{Id}", method = RequestMethod.DELETE)
    @ResponseBody
    ResponseEntity<PointOfInterestDTO> delete(@PathVariable String Id){

        Optional<PointOfInterestDTO> found = crudService.delete(Id);

        if(found.isPresent()){
            return ResponseEntity.ok(found.get());
        }

        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "{Id}", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<PointOfInterestDTO> findBy(@PathVariable String Id){

        Optional<PointOfInterestDTO> found = crudService.findBy(Id);

        if(found.isPresent()){
            return ResponseEntity.ok(found.get());
        }

        return ResponseEntity.notFound().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<List<PointOfInterestDTO>> findAll(){

        List<PointOfInterestDTO> found = listService.findAll();

        if(found.size() > 0){
            return ResponseEntity.ok(found);
        }

        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/search/findByLocationNear", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<List<PointOfInterestDTO>> findByLocationNear(long locationX, long locationY, int distance){

        List<PointOfInterestDTO> found = nearService.findNearby(locationX, locationY, distance);

        if(found.size() > 0){
            return ResponseEntity.ok(found);
        }

        return ResponseEntity.notFound().build();
    }

}
