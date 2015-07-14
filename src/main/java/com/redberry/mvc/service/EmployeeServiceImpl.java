package com.redberry.mvc.service;

import com.redberry.mvc.dao.EmployeeDao;
import com.redberry.mvc.hbnt.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Amila on 7/12/15.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional
    public void insert(Employee employee) {
        employeeDao.insert(employee);
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {
        return employeeDao.getEmployeeById(id);
    }
}
