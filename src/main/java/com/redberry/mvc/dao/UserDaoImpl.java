package com.redberry.mvc.dao;

import com.redberry.mvc.database.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Amila on 7/13/15.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public User getAuthId(String userName, String password) {
        return (User)sessionFactory.getCurrentSession().createCriteria(User.class)
                .add( Restrictions.eq("username", userName))
                .add(Restrictions.eq("password", password))
                .uniqueResult();
    }
}
