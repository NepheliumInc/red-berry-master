package com.redberry.mvc.database;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="room")
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roomId;
    private String roomName;
    private String airconditionState;
    @OneToOne
    private RoomCapacity roomCapacity;
    private Integer displayNumber;
    @OneToOne
    private RoomCategory roomCategory;
    private Integer extensionNumber;


    public Room() {
    }

    public Room(String roomName, String airconditionState, RoomCapacity roomCapacity, Integer displayNumber, RoomCategory roomCategory, Integer extensionNumber) {
        this.roomName = roomName;
        this.airconditionState = airconditionState;
        this.roomCapacity = roomCapacity;
        this.displayNumber = displayNumber;
        this.roomCategory = roomCategory;
        this.extensionNumber = extensionNumber;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getAirconditionState() {
        return airconditionState;
    }

    public void setAirconditionState(String airconditionState) {
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

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
