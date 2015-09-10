package com.redberry.mvc.service;

import com.redberry.mvc.database.CheckIn;

import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Kokila on 9/8/15.
 */

@Path("/checkin")
@WebService(name="services")
public interface CheckInService {
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getcheckins")
    public Response getCheckIns();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getcheckin")
    public Response getCheckIn(@QueryParam("Id") int id);


    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/addcheckin")
    public Response addCheckIn(CheckIn checkIn);

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("updatecheckin")
    public Response updateCheckIn(CheckIn checkIn);

    @DELETE
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("deletecheckin")
    public Response removeCheckIn(CheckIn checkIn);
}
