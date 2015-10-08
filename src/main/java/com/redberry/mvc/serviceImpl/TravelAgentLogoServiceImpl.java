package com.redberry.mvc.serviceImpl;

import com.redberry.mvc.service.TravelAgentLogoService;
import com.redberry.mvc.service.TravelAgentService;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Created by Lakshan Vithana on 10/8/2015.
 */
public class TravelAgentLogoServiceImpl implements TravelAgentLogoService {
    @Context
    ServletContext context;

    @Override
    public Response upload(InputStream inputStream, Attachment attachment) {

        String path = "upload/travelagentlogo/"+attachment.getContentDisposition().getParameter("filename");


        try{


            File f = new File("upload/travelagentlogo/");

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
