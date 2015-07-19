package com.redberry.mvc.dao;

import com.redberry.mvc.hbnt.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Amila on 7/13/15.
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Customer getCustomerById(int id) {
        return (Customer)sessionFactory.getCurrentSession().get(Customer.class,id);
    }

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customerList = sessionFactory.getCurrentSession().createCriteria(Customer.class).list();
        return customerList;
    }
}
