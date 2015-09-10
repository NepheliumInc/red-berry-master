package com.redberry.mvc.database;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;
import java.util.Date;


/**
 * Created by Kokila on 9/8/15.
 */
@XmlRootElement(name="checkin")
@Entity
public class CheckIn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    private Customer customer;
    @OneToOne
    private TravelAgent travelAgent;
    @OneToMany
    private Collection<Room> room;
    private Date checkIn;
    private Date checkOut;


    public CheckIn() {
    }

    public CheckIn(Customer customer, TravelAgent travelAgent, Collection<Room> room, Date checkIn, Date checkOut) {

        this.customer = customer;
        this.travelAgent = travelAgent;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public TravelAgent getTravelAgent() {
        return travelAgent;
    }

    public void setTravelAgent(TravelAgent travelAgent) {
        this.travelAgent = travelAgent;
    }

    public Collection<Room> getRoom() {
        return room;
    }

    public void setRoom(Collection<Room> room) {
        this.room = room;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }
}
