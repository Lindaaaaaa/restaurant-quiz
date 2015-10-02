package ca.ubc.cs.cpsc210.quiz.google;


import ca.ubc.cs.cpsc210.quiz.model.LatLng;
import ca.ubc.cs.cpsc210.quiz.model.Leg;
import ca.ubc.cs.cpsc210.quiz.model.Route;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static ca.ubc.cs.cpsc210.quiz.google.PolylineDecoder.decodePoly;



/**
 * Parser for response from Google Directions API.
 */
public class GoogleDirectionsParser {

    public static Route parseRoute(String response) throws JSONException{
        Leg leg;
        Route route = new Route();
        JSONArray jRoutes ;
        JSONArray jLegs ;
        JSONArray jSteps;
        JSONObject jOneRoute;
        JSONObject jOneLeg;
        JSONObject jDistance;
        JSONObject jOneStep;
        JSONObject jPolyline;
        String points;
        List<LatLng> listpoints;
        List<LatLng>listlatlng;
      listlatlng=new LinkedList<LatLng>();
        List<Leg>legs;
        legs=new LinkedList<Leg>();
        listpoints=new LinkedList<LatLng>();

try{
        int value;
            JSONObject jObject = new JSONObject(response);

            jRoutes = jObject.getJSONArray("routes");

            for (int i = 0; i < jRoutes.length(); i++) {
                jOneRoute= jRoutes.getJSONObject(i);
                jLegs = jOneRoute.getJSONArray("legs");


                for (int j = 0; j < jLegs.length(); j++) {
                    leg=new Leg();
                    jOneLeg=jLegs.getJSONObject(j);
                    jDistance=jOneLeg.getJSONObject("distance");
                    value=jDistance.getInt("value");
                    leg.setDistance(value);
                    jSteps = jOneLeg.getJSONArray("steps");

                    for (int k = 0; k < jSteps.length(); k++) {
                       jOneStep=jSteps.getJSONObject(k);
                       jPolyline=jOneStep.getJSONObject("polyline");
                       points=jPolyline.getString("points");
                       listpoints=PolylineDecoder.decodePoly(points);


                        for (int l = 0; l < listpoints.size(); l++) {
                            listlatlng.add(listpoints.get(l));

                        }
                    }
                leg.addAllPoints(listlatlng);
                legs.add(leg);
                listlatlng.clear();
                }
                for(Leg currentleg:legs){
                    route.addLeg(currentleg);
                }

            }}
catch (JSONException e){}





        return route;

}}





