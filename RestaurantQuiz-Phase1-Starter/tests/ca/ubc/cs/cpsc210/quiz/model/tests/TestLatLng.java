package ca.ubc.cs.cpsc210.quiz.model.tests;

import ca.ubc.cs.cpsc210.quiz.model.LatLng;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mac on 23/10/2014.
 */
public class TestLatLng {
    private static final double DELTA= 1e-7;
    private LatLng mylatlong;

    @Before
    public void setUpBeforeEachTest() {
        mylatlong=new LatLng(3.2,5.3);
    }

    @Test
    public void testgetLat() {

        assertEquals(mylatlong.getLat(),3.2,DELTA);

    }
    @Test
    public void testgetLong(){

        assertEquals(mylatlong.getLng(),5.3,DELTA);
    }
}

