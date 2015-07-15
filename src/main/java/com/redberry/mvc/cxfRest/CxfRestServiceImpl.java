package com.redberry.mvc.cxfRest;

import com.redberry.mvc.dao.EmployeeDao;
import com.redberry.mvc.hbnt.Customer;
import com.redberry.mvc.hbnt.Employee;
import com.redberry.mvc.service.CustomerService;
import com.redberry.mvc.service.EmployeeService;
import com.redberry.mvc.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.core.Response;

/**
 * Created by Amila on 7/13/15.
 */
public class CxfRestServiceImpl implements CxfRestService {

    @Autowired
    private CustomerService customerService;

    @Override
    public Response getEmployeeDetail(String employeeId) {
        if(employeeId==null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }else {
            Customer c = (Customer)customerService.getCustomerById(Integer.parseInt(employeeId));
            return Response.ok(c).build();
        }
    }
}
