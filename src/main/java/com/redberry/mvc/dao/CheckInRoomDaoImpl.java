package com.redberry.mvc.dao;

import com.redberry.mvc.database.CheckInRoom;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Kokila on 9/8/15.
 */
@Repository
public class CheckInRoomDaoImpl implements CheckInRoomDao {

    @Autowired
    private SessionFactory sessionFactory;
    

    @Override
    public void addCheckInRoom(CheckInRoom checkInRoom) {
        sessionFactory.getCurrentSession().saveOrUpdate(checkInRoom);
    }

    @Override
    public CheckInRoom getCheckInRoom(int id) {
        return (CheckInRoom)sessionFactory.getCurrentSession().get(CheckInRoom.class,id);
    }

    @Override
    public List<CheckInRoom> getCheckInRooms() {
        return sessionFactory.getCurrentSession().createCriteria(CheckInRoom.class).list();
    }

    @Override
    public void updateCheckInRoom(CheckInRoom checkInRoom) {
        sessionFactory.getCurrentSession().update(checkInRoom);
    }

    @Override
    public void removeCheckInRoom(CheckInRoom checkInRoom) {
        sessionFactory.getCurrentSession().delete(checkInRoom);
    }
}
