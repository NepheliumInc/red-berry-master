package com.redberry.mvc.serviceImpl;

import com.redberry.mvc.dao.RoomDaoImpl;
import com.redberry.mvc.hbnt.Room;
import com.redberry.mvc.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.core.Response;

/**
 * Created by Amila on 7/31/15.
 */
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomDaoImpl roomDaoImpl;

    @Transactional
    @Override
    public Response getRooms() {
        return Response.ok(roomDaoImpl.getRooms()).build();
    }

    @Transactional
    @Override
    public Response getRoomById(int roomId) {
        return Response.ok(roomDaoImpl.getRoomById(roomId)).build();
    }

    @Transactional
    @Override
    public Response addRoom(Room room) {
        roomDaoImpl.addRoom(room);
        return Response.status(Response.Status.CREATED).build();
    }

    @Transactional
    @Override
    public Response updateEmployee(Room room) {
        roomDaoImpl.updateRoom(room);
        return Response.status(Response.Status.CREATED).build();
    }

    @Transactional
    @Override
    public Response removeEmployee(Room room) {
        roomDaoImpl.removeRoom(room);
        return Response.status(Response.Status.GONE).build();
    }
}
