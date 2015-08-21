package com.redberry.mvc.dao;

import com.redberry.mvc.database.Employee;

import java.util.List;

/**
 * Created by Amila on 7/12/15.
 */
public interface EmployeeDao {
    public void addEmployee(Employee employee);
    public Employee getEmployeeById(int id);
    public List<Employee> getEmployees();
    public void updateEmployee(Employee employee);
    public void removeEmployee(Employee employee);
}
