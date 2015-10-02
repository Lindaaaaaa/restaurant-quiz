package ca.ubc.cs.cpsc210.quiz.yelp;

import ca.ubc.cs.cpsc210.quiz.model.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Parser for JSON data returned by Yelp.
 */
public class YelpDataParser {
    public static List<Restaurant> parseRestaurantData(String response, String yelpCityFilter) throws JSONException {

        JSONArray jBusinesses;
        JSONObject jLocation;
        JSONObject jOneBusiness;
        JSONArray jCategories;
        JSONArray jOneCategory;
        Boolean r_close;
        List<Restaurant> listRestaurant;
        listRestaurant = new ArrayList<Restaurant>();
        String r_name;
        String r_id;
        List<Category> listCategories;
        listCategories = new LinkedList<Category>();
        String c_name;
        String c_alias;
        Category c;
        JSONArray jAddress;
        String postal_code;
        String address;
        JSONArray jNeighborhoods;
        GeoArea geoArea;
        String cityName;
        String stateCode;
        String country_code;
        String NeighbourhoodName;
        Object postalObject;

        JSONObject jObject = new JSONObject(response);
        jBusinesses = jObject.getJSONArray("businesses");

        for (int i = 0; i < jBusinesses.length(); i++) {
            jOneBusiness = jBusinesses.getJSONObject(i);
            r_name = jOneBusiness.getString("name");
            r_id = jOneBusiness.getString("id");

            r_close = jOneBusiness.getBoolean("is_closed");
            jLocation = jOneBusiness.getJSONObject("location");


                postalObject = jLocation.opt("postal_code");
            if (postalObject!=null){
                postal_code=postalObject.toString();
            }
            else postal_code=null;

            jAddress = jLocation.getJSONArray("address");
            address = jAddress.getString(0);


            cityName = jLocation.getString("city");
            stateCode = jLocation.getString("state_code");
            country_code = jLocation.getString("country_code");


                //try{jNeighborhoods = jLocation.getJSONArray("neighborhoods");}
               // catch(JSONException e){geoArea = new City(cityName, stateCode, country_code);}
               // if (jNeighborhoods.length() == 0) {
                //    geoArea = new City(cityName, stateCode, country_code);
            jNeighborhoods = jLocation.optJSONArray("neighborhoods");
                    if (jNeighborhoods!=null) {
                        NeighbourhoodName = jNeighborhoods.getString(0);
                        geoArea = new Neighbourhood(NeighbourhoodName, new City(cityName, stateCode, country_code));
                    }
            else
                        geoArea = new City(cityName, stateCode, country_code);



                jCategories = jOneBusiness.getJSONArray("categories");
                listCategories = new LinkedList<Category>();
                for (int j = 0; j < jCategories.length(); j++) {

                    jOneCategory = jCategories.getJSONArray(j);
                    c_name = jOneCategory.getString(0);
                    c_alias = jOneCategory.getString(1);
                    c = new Category(c_name, c_alias);
                    listCategories.add(c);
                }

                Restaurant r = new Restaurant(r_name, listCategories, r_id, address, postal_code, geoArea);

                if ((!r_close) && (r.getGeographicalArea().getCityString().contains((yelpCityFilter)))) {
                    listRestaurant.add(r);
                }}



        return listRestaurant;

}}







