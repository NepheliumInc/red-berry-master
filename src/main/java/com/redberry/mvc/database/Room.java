package com.redberry.mvc.database;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="room")
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roomId;
    private Integer airconditionState;
    @OneToOne
    private RoomCapacity roomCapacity;
    private Integer displayNumber;
    @OneToOne
    private RoomCategory roomCategory;
    private Integer extensionNumber;


    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Integer getAirconditionState() {
        return airconditionState;
    }

    public void setAirconditionState(Integer airconditionState) {
        this.airconditionState = airconditionState;
    }

    public RoomCapacity getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(RoomCapacity roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public Integer getDisplayNumber() {
        return displayNumber;
    }

    public void setDisplayNumber(Integer displayNumber) {
        this.displayNumber = displayNumber;
    }

    public RoomCategory getRoomCategory() {
        return roomCategory;
    }

    public void setRoomCategory(RoomCategory roomCategory) {
        this.roomCategory = roomCategory;
    }

    public Integer getExtensionNumber() {
        return extensionNumber;
    }

    public void setExtensionNumber(Integer extensionNumber) {
        this.extensionNumber = extensionNumber;
    }
}
