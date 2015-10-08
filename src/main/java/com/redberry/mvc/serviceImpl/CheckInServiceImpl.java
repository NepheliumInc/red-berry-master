package com.redberry.mvc.serviceImpl;

import com.redberry.mvc.dao.CheckInRoomDaoImpl;
import com.redberry.mvc.database.CheckInRoom;
import com.redberry.mvc.service.CheckInRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.core.Response;

/**
 * Created by Amila on 7/31/15.
 */
@Service
public class CheckInServiceImpl implements CheckInRoomService {

    @Autowired
    private CheckInRoomDaoImpl checkInRoomDaoImpl;

    @Transactional
    @Override
    public Response getCheckInRooms() {
        return Response.ok(checkInRoomDaoImpl.getCheckInRooms()).build();
    }

    @Transactional
    @Override
    public Response getCheckInRoom(int roomId) {
        return Response.ok(checkInRoomDaoImpl.getCheckInRoom(roomId)).build();
    }

    @Transactional
    @Override
    public Response addCheckInRoom(CheckInRoom checkInRoom) {
        checkInRoomDaoImpl.addCheckInRoom(checkInRoom);
        return Response.status(Response.Status.CREATED).build();
    }

    @Transactional
    @Override
    public Response updateCheckInRoom(CheckInRoom checkInRoom) {
        checkInRoomDaoImpl.updateCheckInRoom(checkInRoom);
        return Response.status(Response.Status.CREATED).build();
    }

    @Transactional
    @Override
    public Response removeCheckInRoom(CheckInRoom checkInRoom) {
        checkInRoomDaoImpl.removeCheckInRoom(checkInRoom);
        return Response.status(Response.Status.GONE).build();
    }
}
