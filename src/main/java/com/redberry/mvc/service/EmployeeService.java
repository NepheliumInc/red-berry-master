package com.redberry.mvc.service;

import com.redberry.mvc.dao.EmployeeDao;
import com.redberry.mvc.hbnt.Employee;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;
import org.springframework.http.HttpRequest;

import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Amila on 7/12/15.
 */
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
