package ca.ubc.cs.cpsc210.quiz.yelp.tests;


import ca.ubc.cs.cpsc210.quiz.model.Category;
import ca.ubc.cs.cpsc210.quiz.model.Restaurant;
import ca.ubc.cs.cpsc210.quiz.yelp.YelpDataParser;
import org.json.JSONException;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class YelpDataParserTest {
    private static final String FILEPATH = "./testdata/yelp-restaurants-multiple.json";
    private static StringBuilder jsonResponse;
    private static List<Restaurant> restaurants;
    private Category Category1;
    private Category Category2;
    private Category Category3;
    private LinkedList<Category>Categories;


    @BeforeClass
    public static void runBefore() {
        try {
            BufferedReader in = new BufferedReader(new FileReader(FILEPATH));
            jsonResponse = new StringBuilder();
            String str;
            while ((str = in.readLine()) != null) {
                jsonResponse.append(str);
            }
            in.close();
            parseRestaurants();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseRestaurants() {
        try {
            restaurants = YelpDataParser.parseRestaurantData(jsonResponse.toString(), "Vancouver");
        } catch (JSONException e) {
            e.printStackTrace();
            fail("Basic parsing failed");
        }
    }

    @Test
    public void testNumRestaurants() {
        assertEquals(10, restaurants.size());
    }

    @Test
    public void testFirstRestaurantAddress() {
        Restaurant r = restaurants.get(0);

        assertEquals("1509 W 12th Avenue", r.getAddress());
    }
    @Test
    public void testFirstRestaurantCategories(){

        Category1=new Category("Breakfast & Brunch","breakfast_brunch");
        Category2=new Category("Vegetarian","vegetarian");
        Category3=new Category("Vegan","vegan");
        Categories=new LinkedList<Category>();
        Categories.add(Category1);
        Categories.add(Category2);
        Categories.add(Category3);

        Restaurant r=restaurants.get(0);
        assertEquals(r.getCategories(),Categories );
    }

    // many more test cases need to be added!
}
