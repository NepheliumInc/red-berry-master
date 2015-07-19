package com.redberry.mvc.service;

import com.redberry.mvc.dao.CustomerDao;

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

@Path("/customer")
@WebService(name ="services")
public interface CustomerService {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getcustomers")
    public Response getCustomers();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getcustomerbyid")
    public Response getCustomerById(@QueryParam("customerId")int customerId);

}
