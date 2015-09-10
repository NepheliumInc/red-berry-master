package com.redberry.mvc.service;

import com.redberry.mvc.dao.CustomerDao;
import com.redberry.mvc.database.Customer;

import javax.jws.WebService;
import javax.ws.rs.*;
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

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/addcustomer")
    public Response addCustomer(Customer customer);

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("updatecustomer")
    public Response updateCustomer(Customer customer);

    @DELETE
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("deletecustomer")
    public Response removeCustomer(Customer customer);

}
