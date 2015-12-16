/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import entity.Link;
import entity.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Casper
 */
public class JSONConvert {

    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();

    private static LinkFacade facade = new LinkFacade();

    public static Link getLinkFromJson(String js) {
        return gson.fromJson(js, Link.class);
    }

    public static String getJSONFromLink(Link link) {
        return gson.toJson(link);
    }

    public static String getJSONFromLinks(List<Link> links) {
        return gson.toJson(links);
    }

    public static List<String> getListFromDateNumbers(String from, String date, int numbers) {

        List<Link> linkList = facade.getAllLinks();
        List<String> airlineLinks = new ArrayList();
        for (Link l : linkList) {
            String string = new String();
            string = l.getUrl() + "flightinfo/" + from + "/" + date + "/" + gson.toJson(numbers);
            System.out.println(string);
            airlineLinks.add(string);
        }
        return airlineLinks;
    }

    public static List<String> getListFromToDateNumbers(String from, String to, String date, int numbers) {
        List<Link> linkList = facade.getAllLinks();
        List<String> airlineLinks = new ArrayList();
        for (Link l : linkList) {
            String string = new String();
            string = l.getUrl() + "flightinfo/" + from + "/" + to + "/" + date + "/" + gson.toJson(numbers);
            System.out.println(string);
            airlineLinks.add(string);
        }
        return airlineLinks;
    }

    public static User getUserFromJson(String js) {
        return gson.fromJson(js, User.class);
    }

    public static String getJSONFromUser(User u) {
        return gson.toJson(u);
    }

    public static String getJSONFromReservation(String id, int nos, String passengers) {

        String[] ids = passengers.split(",");

        JsonObject jo = new JsonObject();
        jo.addProperty("flightID", id);
        jo.addProperty("numberOfSeats", nos);
        jo.addProperty("ReserveeName", ids[0]);
        jo.addProperty("ReservePhone", "43211234");
        JsonArray passengerArray = new JsonArray();
        for (String id1 : ids) {
            JsonObject passenger1 = new JsonObject();
            passenger1.addProperty("firstname", id1);
            passenger1.addProperty("lastname", id1);
            passengerArray.add(passenger1);
        }
        jo.add("passengers", passengerArray);
        String jsonStr = gson.toJson(jo);
        return jsonStr;
    }

}
