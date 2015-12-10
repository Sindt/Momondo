/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Link;
import java.util.ArrayList;
import java.util.Date;
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

    public static List<String> getJSONFromDateNumbers(String from, String date, int numbers) {
      
        List<Link> linkList = facade.getAllLinks();
        List<String> jsonLinks = new ArrayList();
        for (Link l : linkList) {
            String string = new String();
            string = l.getUrl() + from + "/" + date + "/" + gson.toJson(numbers);
            
            jsonLinks.add(string);
        }
        return jsonLinks;
    }

    public static String getJSONFromDateNumbers(String from, String to, String date, int numbers) {
        List<Link> linkList = facade.getAllLinks();
        String json = "";
        for (Link l : linkList) {
            json = l.getUrl() + from + "/" + to + "/" + date + "/" + gson.toJson(numbers);
        }
        return json;
    }

}
