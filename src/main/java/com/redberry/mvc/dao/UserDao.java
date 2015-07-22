package com.redberry.mvc.dao;


import com.redberry.mvc.database.User;

/**
 * Created by Amila on 7/13/15.
 */
public interface UserDao {
    public User getAuthId(String userName, String password);
}
