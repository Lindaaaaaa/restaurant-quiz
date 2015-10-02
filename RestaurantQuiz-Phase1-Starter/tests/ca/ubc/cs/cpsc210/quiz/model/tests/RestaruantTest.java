package ca.ubc.cs.cpsc210.quiz.model.tests;

import ca.ubc.cs.cpsc210.quiz.model.Category;
import ca.ubc.cs.cpsc210.quiz.model.City;
import ca.ubc.cs.cpsc210.quiz.model.GeoArea;
import ca.ubc.cs.cpsc210.quiz.model.Restaurant;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by mac on 30/10/2014.
 */
public class RestaruantTest {
    LinkedList<Category>categories;
    GeoArea geoArea;
    Restaurant r1;
    Restaurant r2;
@Before
    public void runBefore(){
    Category c1=new Category("Chinese","excellent");
    Category c2=new Category("Japanese","good");
    categories=new LinkedList<Category>();
    categories.add(c1);
    categories.add(c2);
    geoArea=new City("Vancouver","BC","AB");


    r1=new Restaurant("ab", categories,"123","2525 West Mall","V6T1W9",geoArea);
    r2=new Restaurant("ab", categories,"123","2525 West Mall","V6T1W9",geoArea);
}
@Test
public void testgetaddress(){
    assertEquals(r1.getAddress(), "2525 West Mall");
}
    @Test
    public void testgetCategories(){
        assertEquals(r1.getCategories().size(),2);
    }
    @Test
    public void testid() {
        assertEquals(r1.getId(), "123");
    }
    @Test
    public void testname(){
        assertEquals(r1.getName(),"ab");
    }
    @Test
    public void test(){
        assertEquals(r1.getPostalCode(),"V6T1W9");}
    @Test
    public void testgeo(){
        assertEquals(r1.getGeographicalArea().getCityString(),"Vancouver, BC, AB");

    }
   @Test
    public void testequal(){
       assertTrue(r1.equals(r2));

   }
    @Test
    public void testtoString(){
        assertEquals(r1.toString(),"ab, Vancouver, BC, AB, V6T1W9");
    }



}
