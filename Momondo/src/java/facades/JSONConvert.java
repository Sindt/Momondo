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
import java.util.List;

/**
 *
 * @author Casper
 */
public class JSONConvert {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();

    public static Link getLinkFromJson(String js) {
        return gson.fromJson(js, Link.class);
    }

    public static String getJSONFromLink(Link link) {
        return gson.toJson(link);
    }

    public static String getJSONFromLinks(List<Link> links) {
        return gson.toJson(links);
    }
    

}