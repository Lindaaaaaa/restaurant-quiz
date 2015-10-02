package ca.ubc.cs.cpsc210.quiz.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a name having a name, province/state code and country code
 */
public class City implements GeoArea {
    private String name;
    private String province;
    private String countryCode;
    private List<String> allGeoString;

    public City(String cityName, String province, String countryCode) throws IllegalArgumentException {
        if (countryCode.length()!=2)
            throw new IllegalArgumentException("countryCode length should be 2");
        if(province.length()!=2)
            throw new IllegalArgumentException("province length should be 2");
        this.name = cityName;
        this.province = province;
        this.countryCode = countryCode;
        allGeoString = new ArrayList<String>();
    }

    @Override
    public String getCityString() {
        return this.name+","+" "+this.province+","+" "+this.countryCode;

    }

    @Override
    //Produces an array of strings that contains only the string produced by getCityString
    public List<String> getAllGeoStrings() {
        allGeoString.add(getCityString());
        return allGeoString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof GeoArea)) return false;

        if (o instanceof Neighbourhood) {
            Neighbourhood n=(Neighbourhood)o;
            return this.getCityString().equals(n.getCityString());
        }
        City city = (City) o;
        // when o is a City, this Neighborhood is equal to o if the cities are equal


        if (!(o instanceof City)) return false;



        if (countryCode != null ? !countryCode.equals(city.countryCode) : city.countryCode != null) return false;
        if (name != null ? !name.equals(city.name) : city.name != null) return false;
        if (province != null ? !province.equals(city.province) : city.province != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        return result;
    }
}