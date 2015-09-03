package com.redberry.mvc.serviceImpl;

import com.redberry.mvc.dao.RoomCapacityDaoImpl;
import com.redberry.mvc.database.RoomCapacity;
import com.redberry.mvc.service.RoomCapacityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.core.Response;

/**
 * Created by Amila on 9/1/15.
 */
@Service
public class RoomCapacityServiceImpl implements RoomCapacityService{

    @Autowired
    private RoomCapacityDaoImpl roomCapacityDao;

    @Transactional
    @Override
    public Response getRoomCapacities() {
        return Response.ok(roomCapacityDao.getRoomCapacities()).build();
    }

    @Transactional
    @Override
    public Response getRoomCapacityById(int roomCapacityId) {
        return Response.ok(roomCapacityDao.getRoomCapacityById(roomCapacityId)).build();
    }

    @Transactional
    @Override
    public Response addRoomCapacity(RoomCapacity roomCapacity) {
        roomCapacityDao.addRoomCapacity(roomCapacity);
        return Response.status(Response.Status.CREATED).build();
    }

    @Transactional
    @Override
    public Response updateRoomCapacity(RoomCapacity roomCapacity) {
        roomCapacityDao.updateRoomCapacity(roomCapacity);
        return Response.status(Response.Status.CREATED).build();
    }

    @Transactional
    @Override
    public Response removeRoomCapacity(RoomCapacity roomCapacity) {
        roomCapacityDao.removeRoomCapacity(roomCapacity);
        return Response.status(Response.Status.GONE).build();
    }
}
