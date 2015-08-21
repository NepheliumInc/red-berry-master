package com.redberry.mvc.dao;

import com.redberry.mvc.database.RoomCategory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Amila on 7/31/15.
 */
@Repository
public class RoomCategoryDaoImpl implements RoomCategoryDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void addRoomCategory(RoomCategory roomCategory) {
        sessionFactory.getCurrentSession().saveOrUpdate(roomCategory);
    }

    @Override
    public RoomCategory getRoomCategoryById(int id) {
        return (RoomCategory)sessionFactory.getCurrentSession().get(RoomCategory.class,id);
    }

    @Override
    public List<RoomCategory> getRoomCategories() {
        return sessionFactory.getCurrentSession().createCriteria(RoomCategory.class).list();
    }

    @Override
    public void updateRoomCategory(RoomCategory roomCategory) {
        sessionFactory.getCurrentSession().update(roomCategory);
    }

    @Override
    public void removeRoomCategory(RoomCategory roomCategory) {
        sessionFactory.getCurrentSession().delete(roomCategory);
    }
}
