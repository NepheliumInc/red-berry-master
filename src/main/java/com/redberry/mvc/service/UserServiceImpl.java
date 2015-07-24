package com.redberry.mvc.service;

import com.redberry.mvc.dao.UserDaoImpl;
import com.redberry.mvc.database.User;
import com.redberry.mvc.model.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.core.Response;

/**
 * Created by Amila on 7/13/15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl userDaoImpl;

    @Transactional
    @Override
    public Response getAuth(String userName, String password) {
        if(userName==null || password==null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }else {
            Auth auth;
            User u = (User)userDaoImpl.getAuthId(userName, password);
            if(u != null){
                auth = new Auth(true,u.getId());
            }else{
                auth = new Auth(false);
            }
            return Response.ok(auth).build();
        }
    }
}
