package br.com.xyinc.PoI.service;

import java.util.List;
import br.com.xyinc.PoI.model.PointOfInterestDTO;

public interface PointOfInterestListService {

    List<PointOfInterestDTO> findAll();

}
