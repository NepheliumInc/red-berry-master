package com.redberry.mvc.dao;


import com.redberry.mvc.database.CheckInRoom;

import java.util.List;

/**
 * Created by Kokila on 9/8/15.
 */
public interface CheckInRoomDao {
    public void addCheckInRoom(CheckInRoom checkInRoom);
    public CheckInRoom getCheckInRoom(int id);
    public List<CheckInRoom> getCheckInRooms();
    public void updateCheckInRoom(CheckInRoom checkInRoom);
    public void removeCheckInRoom(CheckInRoom checkInRoom);
}
