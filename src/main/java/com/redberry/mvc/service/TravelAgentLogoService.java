package com.redberry.mvc.service;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
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
 * Created by Lakshan Vithana on 10/8/2015.
 */

@CrossOriginResourceSharing(allowOrigins = {
        "http://redberry.com","https://redberry.com","http://www.redberry.com","https://www.redberry.com"
})
@Service
@WebService(name = "services")
@Path("/travelagentlogo")
public interface TravelAgentLogoService {

    @POST
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    @Produces({MediaType.TEXT_PLAIN})
    @Path("/upload")
    public Response upload(@Multipart("file")InputStream inputStream, @Multipart("file")Attachment attachment);

}
