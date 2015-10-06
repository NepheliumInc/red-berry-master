package com.redberry.mvc.database;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;


@XmlRootElement(name="roomCategory")
@Entity
public class RoomCategory implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(name = "roomCat_mealPlans", joinColumns = { @JoinColumn(name = "roomCategory_id") },
            inverseJoinColumns = { @JoinColumn(name = "mealPlan_id") },
            uniqueConstraints = {@UniqueConstraint(
                    columnNames = {"roomCategory_id", "mealPlan_id"})}
    )
    private Set<MealPlan> availableMealPlans;


    public RoomCategory() {

    }

    public RoomCategory(String name, String description, Set<MealPlan> availableMealPlans) {
        this.name = name;
        this.description = description;
        this.availableMealPlans = availableMealPlans;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<MealPlan> getAvailableMealPlans() {
        return availableMealPlans;
    }

    public void setAvailableMealPlans(Set<MealPlan> availableMealPlans) {
        this.availableMealPlans = availableMealPlans;
    }
}
