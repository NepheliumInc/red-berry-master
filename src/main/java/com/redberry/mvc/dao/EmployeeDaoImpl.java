package com.redberry.mvc.dao;

import com.redberry.mvc.hbnt.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Amila on 7/12/15.
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insert(Employee employee) {
        sessionFactory.getCurrentSession().saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return (Employee)sessionFactory.getCurrentSession().get(Employee.class,id);
    }
}
