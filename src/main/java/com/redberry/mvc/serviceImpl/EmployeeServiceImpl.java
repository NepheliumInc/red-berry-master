package com.redberry.mvc.serviceImpl;

import com.redberry.mvc.dao.EmployeeDaoImpl;
import com.redberry.mvc.database.Employee;
import com.redberry.mvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * Created by Amila on 7/12/15.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDaoImpl employeeDaoImpl;

    @Transactional
    @Override
    public Response getEmployees() {

        return Response.ok(employeeDaoImpl.getEmployees()).build();
    }


    @Transactional
    @Override
    public Response getEmployeeById(int employeeId) {
        return Response.ok(employeeDaoImpl.getEmployeeById(employeeId)).build();
    }

    @Transactional
    @Override
    public Response addEmployee(Employee employee) {


        employeeDaoImpl.addEmployee(employee);
        return Response.status(Status.CREATED).build();
    }


    @Transactional
    @Override
    public Response updateEmployee(Employee employee) {
        employeeDaoImpl.updateEmployee(employee);
        return Response.status(Response.Status.CREATED).build();
    }

    @Transactional
    @Override
    public Response removeEmployee(Employee employee) {
        employeeDaoImpl.removeEmployee(employee);
        return Response.status(Response.Status.GONE).build();
    }

}
