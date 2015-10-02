package ca.ubc.cs.cpsc210.quiz.model.tests;


import ca.ubc.cs.cpsc210.quiz.model.City;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class CityTest {

    @Test
    public void testGetGeographicalString() {
        City city = new City("Vancouver", "BC", "CA");
        assertEquals("Vancouver, BC, CA", city.getCityString());

    }

    @Test
    public void testGetAllGeoStrings() {
        City city = new City("Vancouver", "BC", "CA");

        List<String> geoStrings = city.getAllGeoStrings();


        assertEquals(1,geoStrings.size());
        assertEquals("Vancouver, BC, CA", geoStrings.get(0));
    }

    @Test
    public void testEqual(){
        City city1 = new City("Vancouver", "BC", "CA");
        City city4=new City("Vancouver", "BC", "CA");
        City city2 =new City ("Toroto","AB","CD");
        City city3 =new City ("Toroto","BC","CD");
        assertFalse(city2.equals(city3));
        assertTrue(city1.equals(city4));
    }
}
