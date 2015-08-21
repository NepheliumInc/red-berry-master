package com.redberry.mvc.service;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.ContentDisposition;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.io.*;




@Service
@WebService(name = "services")
@Path("/uploadservice")
public class TestService {


    @POST
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    @Path("/upload")
    public String uploadFile(
            @Multipart("file")InputStream inputStream,
            @Multipart("file")Attachment attachment
    ){

        String path = "upload/"+attachment.getContentDisposition().getParameter("filename");


        try{

            File f = new File("upload/");

            if(!f.exists()){
                f.mkdir();
            }

            int read = 0;
            byte[] bytes = new byte[1024];
            FileOutputStream out = new FileOutputStream(new File(path));
            while((read = inputStream.read(bytes))!= -1){
                out.write(bytes,0, read);
            }
            out.flush();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return "File uploaded succesfully!!!";
    }
}
