package com.redberry.mvc.hbnt;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Amila on 7/12/15.
 */
@Entity
public class Room {
    private int id;
    private Integer airconditionState;
    private Integer roomCapacityId;
    private Integer displayNumber;
    private Integer roomClassId;
    private Integer extensionNumber;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "aircondition_state", nullable = true, insertable = true, updatable = true)
    public Integer getAirconditionState() {
        return airconditionState;
    }

    public void setAirconditionState(Integer airconditionState) {
        this.airconditionState = airconditionState;
    }

    @Basic
    @Column(name = "room_capacity_id", nullable = true, insertable = true, updatable = true)
    public Integer getRoomCapacityId() {
        return roomCapacityId;
    }

    public void setRoomCapacityId(Integer roomCapacityId) {
        this.roomCapacityId = roomCapacityId;
    }

    @Basic
    @Column(name = "display_number", nullable = true, insertable = true, updatable = true)
    public Integer getDisplayNumber() {
        return displayNumber;
    }

    public void setDisplayNumber(Integer displayNumber) {
        this.displayNumber = displayNumber;
    }

    @Basic
    @Column(name = "room_class_id", nullable = true, insertable = true, updatable = true)
    public Integer getRoomClassId() {
        return roomClassId;
    }

    public void setRoomClassId(Integer roomClassId) {
        this.roomClassId = roomClassId;
    }

    @Basic
    @Column(name = "extension_number", nullable = true, insertable = true, updatable = true)
    public Integer getExtensionNumber() {
        return extensionNumber;
    }

    public void setExtensionNumber(Integer extensionNumber) {
        this.extensionNumber = extensionNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (id != room.id) return false;
        if (airconditionState != null ? !airconditionState.equals(room.airconditionState) : room.airconditionState != null)
            return false;
        if (roomCapacityId != null ? !roomCapacityId.equals(room.roomCapacityId) : room.roomCapacityId != null)
            return false;
        if (displayNumber != null ? !displayNumber.equals(room.displayNumber) : room.displayNumber != null)
            return false;
        if (roomClassId != null ? !roomClassId.equals(room.roomClassId) : room.roomClassId != null) return false;
        if (extensionNumber != null ? !extensionNumber.equals(room.extensionNumber) : room.extensionNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (airconditionState != null ? airconditionState.hashCode() : 0);
        result = 31 * result + (roomCapacityId != null ? roomCapacityId.hashCode() : 0);
        result = 31 * result + (displayNumber != null ? displayNumber.hashCode() : 0);
        result = 31 * result + (roomClassId != null ? roomClassId.hashCode() : 0);
        result = 31 * result + (extensionNumber != null ? extensionNumber.hashCode() : 0);
        return result;
    }
}
