package com.redberry.mvc.service;

import com.redberry.mvc.database.MealPlan;

import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Amila on 9/3/15.
 */
@Path("mealPlan")
@WebService(name = "services")
public interface MealPlanService {
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getMealPlans")
    public Response getMealPlans();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getMealPlanById")
    public Response getMealPlanById(@QueryParam("mealPlanId")int mealPlanId);


    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/addMealPlan")
    public Response addMealPlan(MealPlan mealPlan);

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("updateMealPlan")
    public Response updateMealPlan(MealPlan mealPlan);

    @DELETE
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("deleteMealPlan")
    public Response removeMealPlan(MealPlan mealPlan);
}
