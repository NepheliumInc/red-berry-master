package com.redberry.mvc.dao;


import com.redberry.mvc.database.RoomCapacity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Amila on 9/1/15.
 */

@Repository
public class RoomCapacityDaoImpl implements RoomCapacityDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addRoomCapacity(RoomCapacity roomCapacity) {
        sessionFactory.getCurrentSession().save(roomCapacity);
    }

    @Override
    public RoomCapacity getRoomCapacityById(int id) {
        return (RoomCapacity)sessionFactory.getCurrentSession().get(RoomCapacity.class, id);
    }

    @Override
    public List<RoomCapacity> getRoomCapacities() {
        return sessionFactory.getCurrentSession().createCriteria(RoomCapacity.class).list();
    }

    @Override
    public void updateRoomCapacity(RoomCapacity roomCapacity) {
        sessionFactory.getCurrentSession().update(roomCapacity);
    }

    @Override
    public void removeRoomCapacity(RoomCapacity roomCapacity) {
        sessionFactory.getCurrentSession().delete(roomCapacity);
    }
}
