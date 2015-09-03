package com.redberry.mvc.dao;

import com.redberry.mvc.database.MealPlan;

import java.util.List;

/**
 * Created by Amila on 9/3/15.
 */
public interface MealPlanDao {
    public void addMealPlan(MealPlan mealPlan);
    public MealPlan getMealPlanById(int id);
    public List<MealPlan> getMealPlans();
    public void updateMealPlan(MealPlan mealPlan);
    public void removeMealPlan(MealPlan mealPlan);
}
