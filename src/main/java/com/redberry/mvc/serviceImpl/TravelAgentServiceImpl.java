package com.redberry.mvc.serviceImpl;

import com.redberry.mvc.dao.TravelAgentDaoImpl;
import com.redberry.mvc.database.TravelAgent;
import com.redberry.mvc.service.TravelAgentService;
import com.sun.org.apache.xerces.internal.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.core.Response;

/**
 * Created by Lakshan Vithana on 9/3/2015.
 */
@Service
public class TravelAgentServiceImpl implements TravelAgentService {

    @Autowired
    private TravelAgentDaoImpl travelAgentDaoImple;

    @Transactional
    @Override
    public Response getTravelAgents(){
        return Response.ok(travelAgentDaoImple.getTravelAgents()).build();
    }

    @Transactional
    @Override
    public Response getTravelAgentById(int agentId){
        return Response.ok(travelAgentDaoImple.getTravelAgentById(agentId)).build();
    }

    @Transactional
    @Override
    public Response addTravelAgent(TravelAgent travelAgent){
        travelAgentDaoImple.addTravelAgent(travelAgent);
        return Response.status(Response.Status.CREATED).build();
    }

    @Transactional
    @Override
    public Response updateTravelAgent(TravelAgent travelAgent){
        travelAgentDaoImple.updateTravelAgent(travelAgent);
        return Response.status(Response.Status.CREATED).build();
    }

    @Transactional
    @Override
    public Response removeTravelAgent(TravelAgent travelAgent){
        travelAgentDaoImple.removeTravelAgent(travelAgent);
        return Response.status(Response.Status.GONE).build();
    }


}
