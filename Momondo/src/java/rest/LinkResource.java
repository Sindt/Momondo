/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import facades.JSONConvert;
import facades.LinkFacade;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Sindt
 */
@Path("link")
public class LinkResource {

    LinkFacade facade = new LinkFacade();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LinkResource
     */
    public LinkResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{from}/{date}/{numbers}")
    public Response getJson(@PathParam("from") String from, @PathParam("date") String date, @PathParam("numbers") int numbers) throws IOException {
        Client client = ClientBuilder.newClient();
        List<String> jsonLinks = JSONConvert.getStringLinksFromDateNumbers(from, date, numbers);
        String links = "{\"airlines\":[";
        String airlines = "";
        Response response = null;

        try {

            for (String l : jsonLinks) {
                WebTarget webTarget = client.target(l);
                Invocation invocation = webTarget.request(MediaType.APPLICATION_JSON).buildGet();
                response = invocation.invoke();
                System.out.println(response);
                links += response.readEntity(String.class) + ",";
            }
            airlines = links.substring(0, links.length() - 1);
            airlines += "]}";
            System.out.println(airlines);

        } catch (Exception e) {

        }
        return Response.ok(airlines).build();
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("{from}/{date}/{numbers}")
//    public Response getJson(@PathParam("from") String from, @PathParam("date") String date, @PathParam("numbers") int numbers) throws IOException {
//        URL url;
//        String link = "";
//        HttpURLConnection request = null;
//        JSONObject mergedJSON = new JSONObject();
//        try {
//            link = JSONConvert.getStringLinksFromDateNumbers(from, date, numbers);
//            url = new URL(link);
//            request = (HttpURLConnection) url.openConnection();
//            request.connect();
//
//        } catch (Exception ex) {
//            Logger.getLogger(LinkResource.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return Response.ok(request.getContent()).build();
//    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{from}/{to}/{date}/{numbers}")
    public Response getJson(@PathParam("from") String from, @PathParam("to") String to, @PathParam("date") String date, @PathParam("numbers") int numbers) throws IOException {
        URL url;
        HttpURLConnection request = null;
        try {
            url = new URL(JSONConvert.getJSONFromDateNumbers(from, to, date, numbers));
            request = (HttpURLConnection) url.openConnection();
            request.connect();

        } catch (Exception ex) {
            Logger.getLogger(LinkResource.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return Response.ok(request.getContent()).build();
    }

}
