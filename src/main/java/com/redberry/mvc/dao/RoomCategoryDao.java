package com.redberry.mvc.dao;

import com.redberry.mvc.database.RoomCategory;

import java.util.List;
import java.util.Set;

/**
 * Created by Amila on 7/31/15.
 */
public interface RoomCategoryDao {
    public void addRoomCategory(RoomCategory roomCategory);
    public RoomCategory getRoomCategoryById(int id);
    public Set<RoomCategory> getRoomCategories();
    public void updateRoomCategory(RoomCategory roomCategory);
    public void removeRoomCategory(RoomCategory roomCategory);
}
