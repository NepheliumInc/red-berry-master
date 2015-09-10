package com.redberry.mvc.dao;

import com.redberry.mvc.database.CheckIn;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Kokila on 9/8/15.
 */
@Repository
public class CheckInDaoImpl implements CheckInDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void addCheckIn(CheckIn checkIn) {
        sessionFactory.getCurrentSession().saveOrUpdate(checkIn);
    }

    @Override
    public CheckIn getCheckIn(int id) {
        return (CheckIn)sessionFactory.getCurrentSession().get(CheckIn.class,id);
    }

    @Override
    public List<CheckIn> getCheckIns() {
        return sessionFactory.getCurrentSession().createCriteria(CheckIn.class).list();
    }

    @Override
    public void updateCheckIn(CheckIn checkIn) {
        sessionFactory.getCurrentSession().update(checkIn);
    }

    @Override
    public void removeCheckIn(CheckIn checkIn) {
        sessionFactory.getCurrentSession().delete(checkIn);
    }
}
