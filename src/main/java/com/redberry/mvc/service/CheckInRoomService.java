package com.redberry.mvc.service;

import com.redberry.mvc.database.CheckInRoom;
import com.redberry.mvc.database.CheckInRoom;

import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Kokila on 9/8/15.
 */

@Path("/checkInRoom")
@WebService(name="services")
public interface CheckInRoomService {
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getCheckInRooms")
    public Response getCheckInRooms();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getCheckInRoom")
    public Response getCheckInRoom(@QueryParam("Id") int id);


    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/addCheckInRoom")
    public Response addCheckInRoom(CheckInRoom checkInRoom);

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("updateCheckInRoom")
    public Response updateCheckInRoom(CheckInRoom checkInRoom);

    @DELETE
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("deleteCheckInRoom")
    public Response removeCheckInRoom(CheckInRoom checkInRoom);
}
