package ca.ubc.cs.cpsc210.quiz.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a neighbourhood having a name in a city
 */
public class Neighbourhood implements GeoArea {
    private String neighborhoodName;
    private City city;
    private List<String>list;

    public  Neighbourhood(String neighborhoodName,City city){
        this.neighborhoodName=neighborhoodName;
        this.city=city;
        list=new LinkedList<String>();
    }

    public City getCity(){return city;}

@Override
    public String getCityString() {
        return city.getCityString();
    }

    @Override
    public List<String> getAllGeoStrings(){
        List<String> allGeoStrings = new ArrayList<String>();
        List<String> nbhdNames = new ArrayList<String>();
        String nbhdName0 = new String();
        String nbhdListName = new String();
        nbhdNames= Arrays.asList(neighborhoodName.split(" "));

        for (int i=0;i< nbhdNames.size(); i++){
            if (i==0){
                nbhdName0 = nbhdNames.get(i);
                String geoString0 = nbhdName0.concat(", "+city.getCityString());
                allGeoStrings.add(geoString0);
                nbhdListName=nbhdListName+nbhdName0;
            }
            else if (i > 0) {
                String nbhdName = nbhdNames.get(i);
                nbhdListName = nbhdListName+" "+nbhdName;
                String geoString =nbhdListName+", "+city.getCityString();
                allGeoStrings.add(geoString);
            }
        }
        return allGeoStrings;
    }


    /**
     * Two neighbourhoods are equal if they have the same city and same name
     * When o is a City, this neighbourhood is equal to it, if it has the same city.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        // will have to revisit this if we add subtypes of GeoArea other than City and Neighborhood
        if (o == null || !(o instanceof GeoArea)) return false;

        // when o is a City, this Neighborhood is equal to o if the cities are equal
        if (o instanceof City)
            return city.equals(o);

        // must be a Neighborhood
        Neighbourhood other = (Neighbourhood) o;

        return (city.equals(other.city));
    }

    @Override
    public int hashCode() {
        return city != null ? city.hashCode() : 0;
    }
}
