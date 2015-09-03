package com.redberry.mvc.dao;

import com.redberry.mvc.database.RoomCapacity;

import java.util.List;

/**
 * Created by Amila on 9/1/15.
 */
public interface RoomCapacityDao {
    public void addRoomCapacity(RoomCapacity roomCapacity);
    public RoomCapacity getRoomCapacityById(int id);
    public List<RoomCapacity> getRoomCapacities();
    public void updateRoomCapacity(RoomCapacity roomCapacity);
    public void removeRoomCapacity(RoomCapacity roomCapacity);
}
