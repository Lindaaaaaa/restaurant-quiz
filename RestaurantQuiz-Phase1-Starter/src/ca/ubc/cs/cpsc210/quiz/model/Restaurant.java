package ca.ubc.cs.cpsc210.quiz.model;

import java.util.Collection;
import java.util.List;

/**
 * Represents a restaurant having a street address, geographical area, postal code, name, id categories
 * and list of reviews.
 */
public class Restaurant {
  private GeoArea geoArea;
  private List<Category> categories;
  private String name;
  private String id;
  private String address;
  private String postalCode;
    private String s;

    public Restaurant(String name,List<Category> categories,String id, String address, String postalCode, GeoArea geographicalArea){
        this.name=name;
        this.id=id;
        this.address=address;
        this.postalCode=postalCode;
        this.geoArea=geographicalArea;
        this.categories=categories;

    }

    public String getAddress(){
        return address;
    }
    public String getName(){
        return name;
    }
    public List<Category> getCategories(){
        return categories;
    }
    public String getId(){
        return  id;
    }
    public String getPostalCode(){
        return postalCode;
    }
   public GeoArea getGeographicalArea(){
       return geoArea;
   }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant)) return false;

        Restaurant that = (Restaurant) o;

        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (categories != null ? !categories.equals(that.categories) : that.categories != null) return false;
        if (geoArea != null ? !geoArea.equals(that.geoArea) : that.geoArea != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (postalCode != null ? !postalCode.equals(that.postalCode) : that.postalCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = geoArea != null ? geoArea.hashCode() : 0;
        result = 31 * result + (categories != null ? categories.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        return result;
    }
   public String toString(){
       if (this.postalCode!=null)

       s=this.getName()+", "+geoArea.getAllGeoStrings().get(0)+", "+this.postalCode;
       else
       s=this.getName()+", "+geoArea.getAllGeoStrings().get(0);
       return s;
   }
}