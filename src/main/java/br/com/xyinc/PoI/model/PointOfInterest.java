package br.com.xyinc.PoI.model;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;

public class PointOfInterest {

    public PointOfInterest() {
    }

    public PointOfInterest(String id, String name, GeoJsonPoint location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public PointOfInterest(String name, GeoJsonPoint location) {
        this.name = name;
        this.location = location;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public GeoJsonPoint getLocation() {
        return location;
    }

    public void setLocation(GeoJsonPoint coordinates) {
        this.location = coordinates;
    }

    public String getDocumentId(){
        return this.id;
    }

    private String id;

    private String name;

    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint location;
}
