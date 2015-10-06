package com.redberry.mvc.dao;

import com.redberry.mvc.database.MealPlan;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Amila on 9/3/15.
 */
@Repository
public class MealPlanDaoImpl implements MealPlanDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addMealPlan(MealPlan mealPlan) {
        sessionFactory.getCurrentSession().save(mealPlan);
    }

    @Override
    public MealPlan getMealPlanById(int id) {
        return (MealPlan)sessionFactory.getCurrentSession().load(MealPlan.class, id);
    }

    @Override
    public List<MealPlan> getMealPlans() {
        return sessionFactory.getCurrentSession().createCriteria(MealPlan.class).list();
    }

    @Override
    public void updateMealPlan(MealPlan mealPlan) {
        sessionFactory.getCurrentSession().update(mealPlan);
    }

    @Override
    public void removeMealPlan(MealPlan mealPlan) {
        sessionFactory.getCurrentSession().delete(mealPlan);
    }
}
