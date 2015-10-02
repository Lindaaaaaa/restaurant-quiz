package ca.ubc.cs.cpsc210.quiz.model.tests;

import ca.ubc.cs.cpsc210.quiz.model.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by mac on 30/10/2014.
 */
public class CategoryTest {

    private Category c1;
    private Category c2;
    private Category c3;
    String n1 = "hotpot";
    String n2 = "Asian";

    @Before
    public void runBefore() {
        c1 = new Category(n1, n2);
        c2 = new Category(n1, n2);
        c3=  new Category("hotpot","Chinese");
    }

    @Test
    public void testgetName() {
        assertEquals(c1.getName(), "hotpot");
    }
     @Test
    public void testgetalias() {
        assertEquals(c1.getAlias(), "Asian");
    }
     @Test
    public void testequals() {
        assertTrue(c1.equals(c2));
        assertFalse(c1.equals(c3));
    }
    @Test
    public void testtostring(){
        assertEquals(c1.toString(),"hotpot");
    }
}


