package com.redberry.mvc.dao;

import com.redberry.mvc.database.TravelAgent;

import java.util.List;

/**
 * Created by Lakshan Vithana on 9/1/2015.
 */
public interface TravelAgentDao {
    public void addTravelAgent(TravelAgent travelAgent);
    public TravelAgent getTravelAgentById(int id);
    public List<TravelAgent> getTravelAgents();
    public void updateTravelAgent(TravelAgent travelAgent);
    public void removeTravelAgent(TravelAgent travelAgent);

}
