package com.redberry.mvc.dao;

import com.redberry.mvc.database.Customer;
import com.redberry.mvc.database.Employee;

import java.util.List;

/**
 * Created by Amila on 7/13/15.
 */
public interface CustomerDao {
    public Customer getCustomerById(int id);
    public List<Customer> getCustomers();
    public void addCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public void removeCustomer(Customer customer);
}
