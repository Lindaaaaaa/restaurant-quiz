package ca.ubc.cs.cpsc210.quiz.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents a leg that has an arbitrary number of points and a distance.  Part of a route.
 */
public class Leg {

    private List<LatLng> points;
    private int distance;

    public Leg(){
        points= new LinkedList<LatLng>();

        distance=0;

    }
    public void addPoint(LatLng pt){
        points.add(pt);
    }
    public void addAllPoints(java.util.List<LatLng> pts){
        points.addAll(pts);
    }
    public java.util.List<LatLng> getPoints(){
        return points;
    }
    public void setDistance(int distance){
        this.distance=distance;

    }
    public int getDistance(){return distance;}
}
