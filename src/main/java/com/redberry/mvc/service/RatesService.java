package com.redberry.mvc.service;

import com.redberry.mvc.database.Rates;
import com.redberry.mvc.database.TravelAgent;

import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Lakshan Vithana on 9/11/2015.
 */
@Path("/Rates")
@WebService(name="services")
public interface RatesService {
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getrates")
    public Response getRates();

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/addrates")
    public Response addRates(final Rates[] rates);

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("updaterates")
    public Response updateRates(Rates rates);

    @DELETE
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("deleterates")
    public Response removeRates(Rates rates);
}
