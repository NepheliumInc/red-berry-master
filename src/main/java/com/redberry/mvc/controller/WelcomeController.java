package com.redberry.mvc.controller;


import com.redberry.mvc.hbnt.Employee;
import com.redberry.mvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class WelcomeController {

    @Autowired
    EmployeeService employeeService;


	@RequestMapping(value = "/",method = RequestMethod.GET)
	public ModelAndView showLogin(){
		ModelAndView model = new ModelAndView("index");

		return model;
	}
    @RequestMapping(value = "/registration" ,method = RequestMethod.GET)
    public ModelAndView showRegistration(){
        ModelAndView model = new ModelAndView("registration");
        return model;
    }

    @RequestMapping(value = "/validator" ,method = RequestMethod.POST)
    public ModelAndView changeThePath(@RequestParam Map<String, String> params){
        if(params.get("username").equals("admin") && params.get("password").equals("123")){
            ModelAndView model = new ModelAndView("dashboard");
            return model;
        }else{
            ModelAndView model = new ModelAndView("index");
            return model;
        }

    }



    @RequestMapping(value = "/addEmp", method = RequestMethod.POST)
    @ResponseBody
    public String testResponse(){
        Employee e = employeeService.getEmployeeById(1);
        return e.getName();
    }
}