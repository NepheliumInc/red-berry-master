package com.redberry.mvc.service;

import com.redberry.mvc.database.Employee;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Amila on 7/12/15.
 */
@CrossOriginResourceSharing(allowOrigins = {
        "http://redberry.com","https://redberry.com","http://www.redberry.com","https://www.redberry.com"
})
@Path("/employee")
@WebService(name="services")
public interface EmployeeService {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getemployees")
    public Response getEmployees();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getemployeebyid")
    public Response getEmployeeById(@QueryParam("employeeId")int employeeId);


    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/addemployee")
    public Response addEmployee(Employee employee);

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("updateemployee")
    public Response updateEmployee(Employee employee);

    @DELETE
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("deleteemployee")
    public Response removeEmployee(Employee employee);
//random
}
