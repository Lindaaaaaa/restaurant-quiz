package ca.ubc.cs.cpsc210.quiz.model.tests;

import ca.ubc.cs.cpsc210.quiz.model.LatLng;
import ca.ubc.cs.cpsc210.quiz.model.Leg;
import ca.ubc.cs.cpsc210.quiz.model.Route;

import org.junit.Test;



import static org.junit.Assert.assertEquals;

/**
 * Created by mac on 23/10/2014.
 */
public class TestRoute{
    private Route myRoute;
    private Leg myleg;
    private Leg myleg1;
    private Leg myleg2;
    private Leg myleg3;


    private LatLng point;



    @Test
    public void testAddLeg(){
        myRoute=new Route();
        myleg= new Leg();
        myleg.setDistance(200);
        point=new LatLng(100,399);
        myleg.addPoint(point);
        myRoute.addLeg(myleg);


      assertEquals(myRoute.getLegs().size(), 1);
    }

    @Test
    public void testGetlegs(){
        myRoute=new Route();
        myleg= new Leg();
        myleg.setDistance(200);
        point=new LatLng(100,399);
        myleg.addPoint(point);
        myRoute.addLeg(myleg);

        assertEquals(myRoute.getLegs().size(), 1);
    }
    @Test
    public void testGetDistance(){
        myRoute=new Route();
        myleg1= new Leg();
        myleg2=new Leg();
        myleg3=new Leg();
        myleg1.setDistance(100);
        myleg2.setDistance(50);
        myleg3.setDistance(300);
        myRoute.addLeg(myleg1);
        myRoute.addLeg(myleg2);
        myRoute.addLeg(myleg3);
        assertEquals(myRoute.getDistance(),450);
    }
}
