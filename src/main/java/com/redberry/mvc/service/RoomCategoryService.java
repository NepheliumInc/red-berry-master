package com.redberry.mvc.service;

import com.redberry.mvc.database.RoomCategory;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Amila on 7/31/15.
 */
@CrossOriginResourceSharing(allowOrigins = {
        "http://redberry.com","https://redberry.com","http://www.redberry.com","https://www.redberry.com"
})
@Path("/roomCategory")
@WebService(name="services")
public interface RoomCategoryService {
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getRoomCategories")
    public Response getRoomCategories();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getRoomCategoryById")
    public Response getCategoryById(@QueryParam("roomCategoryId")int roomCategoryId);


    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/addRoomCategory")
    public Response addRoomCategory(RoomCategory roomCategory);

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("updateRoomCategory")
    public Response updateRoomCategory(RoomCategory roomCategory);

    @DELETE
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("deleteRoomCategory")
    public Response removeRoomCategory(RoomCategory roomCategory);
}
