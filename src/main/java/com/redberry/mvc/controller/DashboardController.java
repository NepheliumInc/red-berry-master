package com.redberry.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Amila on 7/8/15.
 */
@Controller
public class DashboardController {
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView showDashboard(){
        ModelAndView model = new ModelAndView("dashboard");
        return model;
    }


    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ModelAndView showEmployee(){
        ModelAndView model = new ModelAndView("employee");
        return model;
    }
}
