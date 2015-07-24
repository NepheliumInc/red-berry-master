package com.redberry.mvc.service;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Amila on 7/13/15.
 */

@Path("/user")
@WebService(name ="services")
public interface UserService {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/auth_user")
    public Response getAuth(@QueryParam("username") String userName, @QueryParam("password") String password);

}
