package com.redberry.mvc.serviceImpl;

import com.redberry.mvc.dao.MealPlanDaoImpl;
import com.redberry.mvc.database.MealPlan;
import com.redberry.mvc.service.MealPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.core.Response;

/**
 * Created by Amila on 9/3/15.
 */
@Service
public class MealPlanServiceImpl implements MealPlanService {

    @Autowired
    private MealPlanDaoImpl mealPlanDao;

    @Transactional
    @Override
    public Response getMealPlans() {
        return Response.ok(mealPlanDao.getMealPlans()).build();
    }

    @Transactional
    @Override
    public Response getMealPlanById(int mealPlanId) {
        return Response.ok(mealPlanDao.getMealPlanById(mealPlanId)).build();
    }

    @Transactional
    @Override
    public Response addMealPlan(MealPlan mealPlan) {
        mealPlanDao.addMealPlan(mealPlan);
        return Response.status(Response.Status.CREATED).build();
    }

    @Transactional
    @Override
    public Response updateMealPlan(MealPlan mealPlan) {
        mealPlanDao.updateMealPlan(mealPlan);
        return Response.status(Response.Status.CREATED).build();
    }

    @Transactional
    @Override
    public Response removeMealPlan(MealPlan mealPlan) {
        mealPlanDao.removeMealPlan(mealPlan);
        return Response.status(Response.Status.GONE).build();
    }
}
