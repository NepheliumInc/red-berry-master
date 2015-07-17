package com.redberry.mvc.cxfRest;

import com.redberry.mvc.dao.EmployeeDao;
import com.redberry.mvc.hbnt.Customer;
import com.redberry.mvc.hbnt.Employee;
import com.redberry.mvc.service.CustomerService;
import com.redberry.mvc.service.EmployeeService;
import com.redberry.mvc.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amila on 7/13/15.
 */
public class CxfRestServiceImpl implements CxfRestService {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private EmployeeService employeeService;

    @Override
    public Response getEmployeeDetail(String employeeId) {
        if(employeeId==null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }else {
            Customer c = (Customer)customerService.getCustomerById(Integer.parseInt(employeeId));
            return Response.ok(c).build();
        }
    }

    @Override
    public Response getEmployeeRoles() {
        List<String> list = new ArrayList<String>();
        list.add("Administrator");
        list.add("Front office manager");
        list.add("Cleaning Staff");
        return Response.ok(list).build();
    }

    @Override
    public Response addEmployee(String name, String salary, String ssn, String date) {

        employeeService.insert(new Employee(name,date,Double.valueOf(salary),ssn));

        return Response.status(Response.Status.OK).build();
    }
}
