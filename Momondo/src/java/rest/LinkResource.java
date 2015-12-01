/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import facades.LinkFacade;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
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
    @Produces("application/json")
    public Response getJson() throws IOException {
        URL url;
        HttpURLConnection request = null;
        try {
            url = new URL(facade.getLink(1L).getUrl());
            request = (HttpURLConnection) url.openConnection();
            request.connect();

        } catch (Exception ex) {
            Logger.getLogger(LinkResource.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Response.ok(request.getContent()).build();
    }

    @PUT
    @Consumes("application/json")
    public void putJson(String content
    ) {
    }
}
