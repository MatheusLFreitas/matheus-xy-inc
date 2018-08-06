package br.com.xyinc.PoI.repository;

import java.util.List;

import br.com.xyinc.PoI.model.PointOfInterest;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.geo.Point;

@Document(collection = "pointOfinterest")
public interface PointOfInterestRepository extends MongoRepository<PointOfInterest, String> {

    List<PointOfInterest> findByLocationWithin(Circle point);
}