package com.redberry.mvc.dao;

import com.redberry.mvc.hbnt.Room;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Amila on 7/31/15.
 */
@Repository
public class RoomDaoImpl implements RoomDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addRoom(Room room) {
        sessionFactory.getCurrentSession().saveOrUpdate(room);
    }

    @Override
    public Room getRoomById(int id) {
        return (Room)sessionFactory.getCurrentSession().get(Room.class,id);
    }

    @Override
    public List<Room> getRooms() {
        return sessionFactory.getCurrentSession().createCriteria(Room.class).list();
    }

    @Override
    public void updateRoom(Room room) {
        sessionFactory.getCurrentSession().update(room);
    }

    @Override
    public void removeRoom(Room room) {
        sessionFactory.getCurrentSession().delete(room);
    }
}
