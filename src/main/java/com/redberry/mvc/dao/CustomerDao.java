package com.redberry.mvc.dao;

import com.redberry.mvc.database.Customer;

import java.util.List;

/**
 * Created by Amila on 7/13/15.
 */
public interface CustomerDao {
    public Customer getCustomerById(int id);
    public List<Customer> getCustomers();
}
