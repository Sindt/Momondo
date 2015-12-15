package rest;

import facades.JSONConvert;
import facades.UserFacade;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * @author Kasper
 */
@Path("user")
public class userRegistration {

    @Context
    private UriInfo context;

    UserFacade facade = new UserFacade();

    @POST
    @Path("registration")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String registerUser(String user) {

        entity.User newUser = JSONConvert.getUserFromJson(user);
        newUser = facade.addUser(newUser.getUserName(), newUser.getPassword());

        return JSONConvert.getJSONFromUser(newUser);
    }
}
