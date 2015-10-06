package com.redberry.mvc.service;

import com.redberry.mvc.database.Room;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Amila on 7/29/15.
 */

@CrossOriginResourceSharing(allowOrigins = {
        "http://redberry.com","https://redberry.com","http://www.redberry.com","https://www.redberry.com"
})
@Path("/room")
@WebService(name="services")
public interface RoomService {
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getrooms")
    public Response getRooms();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getroombyid")
    public Response getRoomById(@QueryParam("roomId")int roomId);


    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/addroom")
    public Response addRoom(Room room);

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("updateroom")
    public Response updateEmployee(Room room);

    @DELETE
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("deleteroom")
    public Response removeEmployee(Room room);
}
