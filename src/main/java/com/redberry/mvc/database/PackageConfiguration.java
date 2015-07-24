package com.redberry.mvc.database;

import javax.persistence.*;

/**
 * Created by Amila on 7/12/15.
 */
@Entity
@Table(name = "PACKAGE_CONFIGURATION", schema = "", catalog = "redberry")
public class PackageConfiguration {
    private int id;
    private String name;
    private Integer roomId;
    private Integer mealConfigurationId;
    private Float price;

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
    @Column(name = "room_id", nullable = true, insertable = true, updatable = true)
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "meal_configuration_id", nullable = true, insertable = true, updatable = true)
    public Integer getMealConfigurationId() {
        return mealConfigurationId;
    }

    public void setMealConfigurationId(Integer mealConfigurationId) {
        this.mealConfigurationId = mealConfigurationId;
    }

    @Basic
    @Column(name = "price", nullable = true, insertable = true, updatable = true, precision = 0)
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PackageConfiguration that = (PackageConfiguration) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (roomId != null ? !roomId.equals(that.roomId) : that.roomId != null) return false;
        if (mealConfigurationId != null ? !mealConfigurationId.equals(that.mealConfigurationId) : that.mealConfigurationId != null)
            return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (roomId != null ? roomId.hashCode() : 0);
        result = 31 * result + (mealConfigurationId != null ? mealConfigurationId.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
