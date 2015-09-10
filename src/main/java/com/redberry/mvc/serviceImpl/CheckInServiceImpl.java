package com.redberry.mvc.serviceImpl;

import com.redberry.mvc.dao.CheckInDaoImpl;
import com.redberry.mvc.database.CheckIn;
import com.redberry.mvc.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.core.Response;

/**
 * Created by Amila on 7/31/15.
 */
@Service
public class CheckInServiceImpl implements CheckInService {

    @Autowired
    private CheckInDaoImpl checkInDaoImpl;

    @Transactional
    @Override
    public Response getCheckIns() {
        return Response.ok(checkInDaoImpl.getCheckIns()).build();
    }

    @Transactional
    @Override
    public Response getCheckIn(int roomId) {
        return Response.ok(checkInDaoImpl.getCheckIn(roomId)).build();
    }

    @Transactional
    @Override
    public Response addCheckIn(CheckIn checkIn) {
        checkInDaoImpl.addCheckIn(checkIn);
        return Response.status(Response.Status.CREATED).build();
    }

    @Transactional
    @Override
    public Response updateCheckIn(CheckIn checkIn) {
        checkInDaoImpl.updateCheckIn(checkIn);
        return Response.status(Response.Status.CREATED).build();
    }

    @Transactional
    @Override
    public Response removeCheckIn(CheckIn checkIn) {
        checkInDaoImpl.removeCheckIn(checkIn);
        return Response.status(Response.Status.GONE).build();
    }
}
