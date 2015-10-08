package com.redberry.mvc.dao;

import com.redberry.mvc.database.TravelAgent;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Lakshan Vithana on 9/1/2015.
 */
@Repository
public class TravelAgentDaoImpl implements TravelAgentDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addTravelAgent(TravelAgent travelAgent){
            sessionFactory.getCurrentSession().saveOrUpdate(travelAgent);
    }

    @Override
    public TravelAgent getTravelAgentById(int id){
        return (TravelAgent) sessionFactory.getCurrentSession().get(TravelAgent.class,id);
    }

    @Override
    public Set<TravelAgent> getTravelAgents(){
        Set<TravelAgent> travelAgentList=new HashSet<TravelAgent>(sessionFactory.getCurrentSession().createCriteria(TravelAgent.class).list());
        return travelAgentList;
    }

    @Override
    public void updateTravelAgent(TravelAgent travelAgent){
        sessionFactory.getCurrentSession().update(travelAgent);
    }
    @Override
    public void removeTravelAgent(TravelAgent travelAgent){
        sessionFactory.getCurrentSession().delete(travelAgent);
    }
}
