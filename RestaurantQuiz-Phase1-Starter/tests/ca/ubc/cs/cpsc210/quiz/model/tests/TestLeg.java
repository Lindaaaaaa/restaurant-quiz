package ca.ubc.cs.cpsc210.quiz.model.tests;

import ca.ubc.cs.cpsc210.quiz.model.LatLng;
import ca.ubc.cs.cpsc210.quiz.model.Leg;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import sun.awt.image.ImageWatched;

import java.util.LinkedList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by mac on 23/10/2014.
 */
public class TestLeg{
    private LinkedList<LatLng> points;
    private LatLng point;
    private Leg myleg;

  @Before
    public void testbefore(){

        myleg=new Leg();
      points= new LinkedList<LatLng>();
    }
    @Test
    public void testaddPoint(){

        point= new LatLng(3.4,2.2);
        myleg.addPoint(point);
        assertEquals(myleg.getPoints().size(), 1);
    }
    @Test
    public void testaddAllPoints(){
        point= new LatLng(3.4,2.2);
        points.add(point);
        point=new LatLng(5.5,23);
        points.add(point);
        myleg.addAllPoints(points);
        assertEquals(myleg.getPoints().size(), 2);

    }
    @Test
    public void testgetPoints(){
        point= new LatLng(3.4,2.2);
        points.add(point);
        point=new LatLng(5.5,23);
        points.add(point);
        myleg.addAllPoints(points);
        assertEquals(myleg.getPoints().size(), 2);

    }
    @Test
    public void testsetDistance(){
        myleg.setDistance(100);
      assertEquals(myleg.getDistance(),100);

    }
@Test
    public void testGetDistance(){
    myleg.setDistance(100);
    assertEquals(myleg.getDistance(),100);
}


}
