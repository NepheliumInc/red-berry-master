package com.redberry.mvc.service;

import com.javafx.tools.doclets.internal.toolkit.util.DocFinder;
import com.redberry.mvc.dao.EmployeeDaoImpl;
import com.redberry.mvc.hbnt.Employee;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.io.*;
import java.util.Scanner;

/**
 * Created by Amila on 7/12/15.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

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
