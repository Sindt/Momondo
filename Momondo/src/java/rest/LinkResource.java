/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.JsonObject;
import entity.Link;
import facades.JSONConvert;
import facades.LinkFacade;
import java.io.IOException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
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
        List<String> jsonLinks = JSONConvert.getListFromDateNumbers(from, date, numbers);
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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{from}/{to}/{date}/{numbers}")
    public Response getJson(@PathParam("from") String from, @PathParam("to") String to, @PathParam("date") String date, @PathParam("numbers") int numbers) throws IOException {
        Client client = ClientBuilder.newClient();
        List<String> jsonLinks = JSONConvert.getListFromToDateNumbers(from, to, date, numbers);
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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addReservation() {
        String jsonStr = JSONConvert.getJSONFromReservation("COL3257x100x2016-01-14T21:30:00.000Z", 2, "Bob,Jens");
        System.out.println(jsonStr);
        Client client = ClientBuilder.newClient();
        List<Link> allLinks = facade.getAllLinks();
        String links = "";
        Response response = null;
        try {
            for (Link l : allLinks) {
                WebTarget webTarget = client.target(l.getUrl() + "flightreservation");
                System.out.println(webTarget);
                Invocation invocation = webTarget.request().buildPost(Entity.entity(jsonStr, MediaType.APPLICATION_JSON));
                response = invocation.invoke();
                System.out.println(response);
            }
            System.out.println(links);
        } catch (Exception e) {
        }

        return Response.ok(response.readEntity(String.class)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}/{nos}")
    public Response addReservation(@PathParam("id") String id, @PathParam("nos") int nos) {
        String jsonStr = JSONConvert.getJSONFromReservation(id, nos, "Mads,Jens");
        System.out.println(jsonStr);
        Client client = ClientBuilder.newClient();
        List<Link> allLinks = facade.getAllLinks();
        String links = "";
        Response response = null;
        try {
            for (Link l : allLinks) {
                WebTarget webTarget = client.target(l.getUrl() + "flightreservation");
                System.out.println(webTarget);
                Invocation invocation = webTarget.request().buildPost(Entity.entity(jsonStr, MediaType.APPLICATION_JSON));
                response = invocation.invoke();
                System.out.println(response);
            }
            System.out.println(links);
        } catch (Exception e) {
        }

        return Response.ok(response.readEntity(String.class)).build();
    }

}
