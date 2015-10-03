package com.redberry.mvc.database;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;



/**
 * Created by Kokila on 9/8/15.
 */
@XmlRootElement(name="CheckInRooms")
@Entity
public class CheckInRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    private Room room;
    @OneToOne
    private MealPlan mealPlan;

    public CheckInRoom() {

    }

    public CheckInRoom(Room room, MealPlan mealPlan) {
        this.room = room;
        this.mealPlan = mealPlan;
    }

    public int getId() {
        return id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public MealPlan getMealPlan() {
        return mealPlan;
    }

    public void setMealPlan(MealPlan mealPlan) {
        this.mealPlan = mealPlan;
    }
}
