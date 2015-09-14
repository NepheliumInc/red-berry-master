package com.redberry.mvc.dao;

import com.redberry.mvc.database.Room;

import java.util.List;
import java.util.Set;

/**
 * Created by Amila on 7/31/15.
 */
public interface RoomDao {
    public void addRoom(Room room);
    public Room getRoomById(int id);
    public Set<Room> getRooms();
    public void updateRoom(Room room);
    public void removeRoom(Room room);
}
