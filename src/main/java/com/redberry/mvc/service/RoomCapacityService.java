package com.redberry.mvc.service;

import com.redberry.mvc.database.RoomCapacity;

import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Amila on 9/1/15.
 */
@Path("/roomCapacity")
@WebService(name="services")
public interface RoomCapacityService {
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getRoomCapacities")
    public Response getRoomCapacities();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getRoomCapacityById")
    public Response getRoomCapacityById(@QueryParam("roomCapacityId")int roomCapacityId);


    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/addRoomCapacity")
    public Response addRoomCapacity(RoomCapacity roomCapacity);

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("updateRoomCapacity")
    public Response updateRoomCapacity(RoomCapacity roomCapacity);

    @DELETE
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("deleteRoomCapacity")
    public Response removeRoomCapacity(RoomCapacity roomCapacity);
}
