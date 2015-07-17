package com.redberry.mvc.cxfRest;

import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Amila on 7/13/15.
 */
@Path("/")
@WebService(name = "employeeService")
public interface CxfRestService {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getemployeedetail")
    public Response getEmployeeDetail(@QueryParam("employeeId") String employeeId);


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getemployeerole")
    public Response getEmployeeRoles();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/addemployee")
    public Response addEmployee(@QueryParam("name")String name,
                                @QueryParam("salary")String designation,
                                @QueryParam("ssn") String ssn,
                                @QueryParam("date")String date);

}
