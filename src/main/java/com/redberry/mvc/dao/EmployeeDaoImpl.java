package com.redberry.mvc.dao;

import com.redberry.mvc.database.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Amila on 7/12/15.
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addEmployee(Employee employee) {
        sessionFactory.getCurrentSession().saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return (Employee)sessionFactory.getCurrentSession().get(Employee.class,id);
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employeeList = sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
        return employeeList;
    }

    @Override
    public void updateEmployee(Employee employee) {
        sessionFactory.getCurrentSession().update(employee);
    }

    @Override
    public void removeEmployee(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }
}
