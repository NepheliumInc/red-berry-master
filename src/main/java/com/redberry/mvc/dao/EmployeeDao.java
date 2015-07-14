package com.redberry.mvc.dao;

import com.redberry.mvc.hbnt.Employee;

/**
 * Created by Amila on 7/12/15.
 */
public interface EmployeeDao {
    public void insert(Employee employee);
    public Employee getEmployeeById(int id);
}
