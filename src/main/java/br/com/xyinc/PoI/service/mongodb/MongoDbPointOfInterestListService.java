package br.com.xyinc.PoI.service.mongodb;

import br.com.xyinc.PoI.model.PointOfInterest;
import br.com.xyinc.PoI.model.PointOfInterestDTO;
import br.com.xyinc.PoI.repository.PointOfInterestRepository;
import br.com.xyinc.PoI.service.PointOfInterestListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MongoDbPointOfInterestListService implements PointOfInterestListService {

    private final PointOfInterestRepository repository;

    @Autowired
    public MongoDbPointOfInterestListService(PointOfInterestRepository repository){
        this.repository = repository;
    }

    @Override
    public List<PointOfInterestDTO> findAll() {
        List<PointOfInterest> source = repository.findAll();

        List<PointOfInterestDTO> result = new ArrayList<>();

        if(source.size() > 0)
            source.forEach(pointOfInterest -> result.add(PointOfInterestDTO.fromPointOfInterest(pointOfInterest)));

        return result;
    }

}
