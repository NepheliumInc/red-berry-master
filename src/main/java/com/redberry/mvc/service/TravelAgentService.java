package com.redberry.mvc.service;

import com.redberry.mvc.database.Employee;
import com.redberry.mvc.database.TravelAgent;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Lakshan Vithana on 9/3/2015.
 */
@CrossOriginResourceSharing(allowOrigins = {
        "http://redberry.com","https://redberry.com","http://www.redberry.com","https://www.redberry.com"
})
@Path("/travelAgent")
@WebService(name="services")
public interface TravelAgentService {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/gettravelagents")
    public Response getTravelAgents();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/gettravelagentbyid")
    public Response getTravelAgentById(@QueryParam("agentId")int agentId);

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/addtravelagent")
    public Response addTravelAgent(TravelAgent travelAgent);

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("updatetravelagent")
    public Response updateTravelAgent(TravelAgent travelAgent);

    @DELETE
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("deletetravelagent")
    public Response removeTravelAgent(TravelAgent travelAgent);
}
