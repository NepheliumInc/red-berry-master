package com.redberry.mvc.service;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;

/**
 * Created by Amila on 9/5/15.
 */
@Service
@WebService(name = "services")
@Path("/employeeImage")
public interface EmployeeImageService {

    @POST
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    @Produces({MediaType.TEXT_PLAIN})
    @Path("/upload")
    public Response upload(@Multipart("file")InputStream inputStream, @Multipart("file")Attachment attachment);

}
