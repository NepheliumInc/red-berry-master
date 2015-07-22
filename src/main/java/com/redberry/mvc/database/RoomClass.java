package com.redberry.mvc.database;

import javax.persistence.*;

/**
 * Created by Amila on 7/12/15.
 */
@Entity
@Table(name = "ROOM_CLASS", schema = "", catalog = "redberry")
public class RoomClass {
    private int id;
    private String name;
    private String description;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 1000)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 1000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomClass roomClass = (RoomClass) o;

        if (id != roomClass.id) return false;
        if (name != null ? !name.equals(roomClass.name) : roomClass.name != null) return false;
        if (description != null ? !description.equals(roomClass.description) : roomClass.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
