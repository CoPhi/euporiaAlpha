package euporia;

import euporia.utils.LoginUtils;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("Login")
public class Login {

    @Context
    private UriInfo context;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String login(euporia.json.Login login) {
        return String.format("{\"loggedIn\": %s}", LoginUtils.login(login.getUsername(), login.getPassword()));
    }
}
