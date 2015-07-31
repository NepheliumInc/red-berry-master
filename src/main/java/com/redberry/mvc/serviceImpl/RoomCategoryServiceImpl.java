package com.redberry.mvc.serviceImpl;

import com.redberry.mvc.dao.RoomCategoryDaoImpl;
import com.redberry.mvc.database.RoomCategory;
import com.redberry.mvc.service.RoomCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.core.Response;

/**
 * Created by Amila on 7/31/15.
 */
@Service
public class RoomCategoryServiceImpl implements RoomCategoryService {

    @Autowired
    private RoomCategoryDaoImpl roomCategoryDaoImpl;

    @Transactional
    @Override
    public Response getRoomCategories() {
        return Response.ok(roomCategoryDaoImpl.getRoomCategories()).build();
    }

    @Transactional
    @Override
    public Response getCategoryById(int roomCategoryId) {
        return Response.ok(roomCategoryDaoImpl.getRoomCategoryById(roomCategoryId)).build();
    }

    @Transactional
    @Override
    public Response addRoomCategory(RoomCategory roomCategory) {
        roomCategoryDaoImpl.addRoomCategory(roomCategory);
        return Response.status(Response.Status.CREATED).build();
    }

    @Override
    public Response updateRoomCategory(RoomCategory roomCategory) {
        roomCategoryDaoImpl.updateRoomCategory(roomCategory);
        return Response.status(Response.Status.CREATED).build();
    }

    @Override
    public Response removeRoomCategory(RoomCategory roomCategory) {
        roomCategoryDaoImpl.removeRoomCategory(roomCategory);
        return Response.status(Response.Status.GONE).build();
    }
}
