package com.redberry.mvc.serviceImpl;

import com.redberry.mvc.service.EmployeeImageService;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Created by Amila on 9/5/15.
 */
public class EmployeeImageServiceImpl implements EmployeeImageService {

    @Context
    ServletContext context;

    @Override
    public Response upload(InputStream inputStream, Attachment attachment) {

        String path = "upload/avatar/"+attachment.getContentDisposition().getParameter("filename");


        try{


            File f = new File("upload/avatar/");

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

        return Response.accepted(path).build();
    }
}
