package br.com.xyinc.PoI.service;

import java.util.Optional;
import br.com.xyinc.PoI.model.PointOfInterestDTO;

public interface PointOfInterestCRUDService {

    PointOfInterestDTO create(PointOfInterestDTO source);
    Optional<PointOfInterestDTO> update(PointOfInterestDTO target);
    Optional<PointOfInterestDTO> delete(String id);
    Optional<PointOfInterestDTO> findBy(String id);

}
