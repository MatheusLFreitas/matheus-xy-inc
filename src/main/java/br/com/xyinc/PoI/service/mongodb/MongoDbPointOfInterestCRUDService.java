package br.com.xyinc.PoI.service.mongodb;

import br.com.xyinc.PoI.model.PointOfInterest;
import br.com.xyinc.PoI.model.PointOfInterestDTO;
import br.com.xyinc.PoI.repository.PointOfInterestRepository;
import br.com.xyinc.PoI.service.PointOfInterestCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MongoDbPointOfInterestCRUDService implements PointOfInterestCRUDService {

    private final PointOfInterestRepository repository;

    @Autowired
    public MongoDbPointOfInterestCRUDService(PointOfInterestRepository repository){
        this.repository = repository;
    }

    @Override
    public PointOfInterestDTO create(PointOfInterestDTO source) {

        PointOfInterest target = new PointOfInterest(
          source.getName(),
          source.getCoordinatesAsPoint()
        );

        return PointOfInterestDTO.fromPointOfInterest(repository.insert(target));
    }

    @Override
    public Optional<PointOfInterestDTO> update(PointOfInterestDTO target) {
        Optional<PointOfInterest> source = repository.findById(target.getDocId());

        Optional<PointOfInterestDTO> result = Optional.empty();

        if(source.isPresent()){

            source.get().setName(target.getName());
            source.get().setLocation(target.getCoordinatesAsPoint());

            PointOfInterest saved = repository.save(source.get());

            result = Optional.of(PointOfInterestDTO.fromPointOfInterest(saved));
        }

        return result;
    }

    @Override
    public Optional<PointOfInterestDTO> delete(String id) {
        Optional<PointOfInterest> source = repository.findById(id);

        Optional<PointOfInterestDTO> result = Optional.empty();

        if(source.isPresent()){

            repository.deleteById(id);

            result = Optional.of(PointOfInterestDTO.fromPointOfInterest(source.get()));
        }

        return result;
    }

    @Override
    public Optional<PointOfInterestDTO> findBy(String id) {
        Optional<PointOfInterest> source = repository.findById(id);

        Optional<PointOfInterestDTO> result = Optional.empty();

        if(source.isPresent()){
            result = Optional.of(PointOfInterestDTO.fromPointOfInterest(source.get()));
        }

        return result;
    }
}
