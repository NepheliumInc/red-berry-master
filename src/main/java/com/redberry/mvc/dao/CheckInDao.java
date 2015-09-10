package com.redberry.mvc.dao;

import com.redberry.mvc.database.CheckIn;

import java.util.List;

/**
 * Created by Kokila on 9/8/15.
 */
public interface CheckInDao {
    public void addCheckIn(CheckIn checkIn);
    public CheckIn getCheckIn(int id);
    public List<CheckIn> getCheckIns();
    public void updateCheckIn(CheckIn checkIn);
    public void removeCheckIn(CheckIn checkIn);
}
