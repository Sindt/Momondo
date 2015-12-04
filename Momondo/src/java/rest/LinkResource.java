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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    public Response getJson() throws IOException {
        URL url;
        HttpURLConnection request = null;
        try {
            url = new URL(JSONConvert.getJSONFromDateNumbers("CPH", "2016-01-01T00:00:00.000Z", 2));
            request = (HttpURLConnection) url.openConnection();
            request.connect();

        } catch (Exception ex) {
            Logger.getLogger(LinkResource.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Response.ok(request.getContent()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{from}/{date}/{numbers}")
    public Response getJson(@PathParam("from") String from, @PathParam("date") String date, @PathParam("numbers") int numbers) throws IOException {
        URL url;
        HttpURLConnection request = null;
        try {
            url = new URL(JSONConvert.getJSONFromDateNumbers(from, date, numbers));
            request = (HttpURLConnection) url.openConnection();
            request.connect();

        } catch (Exception ex) {
            Logger.getLogger(LinkResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.ok(request.getContent()).build();
    }

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
            Logger.getLogger(LinkResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.ok(request.getContent()).build();
    }

}
