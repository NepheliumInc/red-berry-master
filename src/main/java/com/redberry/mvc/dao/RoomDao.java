package com.redberry.mvc.dao;

import com.redberry.mvc.database.Employee;
import com.redberry.mvc.database.Room;

import java.util.List;

/**
 * Created by Amila on 7/31/15.
 */
public interface RoomDao {
    public void addRoom(Room room);
    public Room getRoomById(int id);
    public List<Room> getRooms();
    public void updateRoom(Room room);
    public void removeRoom(Room room);
}
