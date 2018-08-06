package br.com.xyinc.PoI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.hateoas.ResourceSupport;

public class PointOfInterestDTO extends ResourceSupport {

    private String docId;
    private String name;
    private Coordinates coordinates;

    public PointOfInterestDTO() {
    }

    public PointOfInterestDTO(String docId, String name, Coordinates coordinates) {
        this.docId = docId;
        this.name = name;
        this.coordinates = coordinates;
    }

    public PointOfInterestDTO(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    public static PointOfInterestDTO fromPointOfInterest(PointOfInterest saved) {
        return new PointOfInterestDTO(saved.getDocumentId(), saved.getName(), Coordinates.fromPoint(saved.getLocation()));
    }

    public String getDocId() {
        return this.docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @JsonIgnore
    public GeoJsonPoint getCoordinatesAsPoint(){
        return new GeoJsonPoint(coordinates.getX(), coordinates.getY());
    }
}
