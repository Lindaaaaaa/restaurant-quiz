package ca.ubc.cs.cpsc210.quiz.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents a route having a list of legs and a distance.
 */
public class Route {
    private int distance;
    private LinkedList<Leg> legs;

    public Route(){
        legs= new LinkedList<Leg>();
        this.distance=0;

    }
    public void addLeg(Leg leg){
      legs.add(leg);
    }
    public java.util.List<Leg> getLegs(){return legs;}

    public int getDistance() {

        for (Leg current : legs) {
            distance = distance + current.getDistance();
        }
      return distance;
    }


}
