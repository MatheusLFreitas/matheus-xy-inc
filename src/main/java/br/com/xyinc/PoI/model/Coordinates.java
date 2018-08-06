package br.com.xyinc.PoI.model;

import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

public class Coordinates {

    private long x;
    private long y;

    public Coordinates() {
    }

    public Coordinates(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinates fromPoint(GeoJsonPoint location) {
        return new Coordinates((long)location.getX(), (long)location.getY());
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }
}
