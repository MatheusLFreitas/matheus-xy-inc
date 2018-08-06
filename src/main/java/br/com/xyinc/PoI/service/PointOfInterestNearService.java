package br.com.xyinc.PoI.service;

import br.com.xyinc.PoI.model.PointOfInterestDTO;

import java.util.List;

public interface PointOfInterestNearService {

    List<PointOfInterestDTO> findNearby(long locationX, long locationY, int distance);

}
