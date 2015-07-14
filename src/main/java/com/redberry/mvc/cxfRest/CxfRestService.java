package com.redberry.mvc.cxfRest;

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
@Path("/")
@WebService(name = "employeeService")
public interface CxfRestService {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getemployeedetail")
    public Response getEmployeeDetail(@QueryParam("employeeId") String employeeId);

}
