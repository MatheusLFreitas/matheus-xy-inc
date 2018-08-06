package br.com.xyinc.PoI.service.mongodb;

import br.com.xyinc.PoI.model.PointOfInterest;
import br.com.xyinc.PoI.model.PointOfInterestDTO;
import br.com.xyinc.PoI.repository.PointOfInterestRepository;
import br.com.xyinc.PoI.service.PointOfInterestNearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MongoDbPointOfInterestNearService implements PointOfInterestNearService {

    private final PointOfInterestRepository repository;

    @Autowired
    public MongoDbPointOfInterestNearService(PointOfInterestRepository repository){
        this.repository = repository;
    }

    @Override
    public List<PointOfInterestDTO> findNearby(long locationX, long locationY, int distance) {

        List<PointOfInterest> source = repository.findByLocationWithin(
                new Circle(new GeoJsonPoint(locationX, locationY),
                           new Distance(distance, Metrics.NEUTRAL))
        );

        List<PointOfInterestDTO> result = new ArrayList<>();

        if(source.size() > 0)
            source.forEach(pointOfInterest -> result.add(PointOfInterestDTO.fromPointOfInterest(pointOfInterest)));

        return result;
    }
}
