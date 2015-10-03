package com.redberry.mvc.serviceImpl;

import com.redberry.mvc.dao.CustomerDaoImpl;
import com.redberry.mvc.database.Customer;
import com.redberry.mvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Amila on 7/13/15.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDaoImpl customerDaoImpl;



    @Transactional
    @Override
    public Response getCustomers() {

        List<Customer> customerList = customerDaoImpl.getCustomers();

        return Response.ok(customerList).build();
    }

    @Transactional
    @Override
    public Response getCustomerById(int customerId) {
        return Response.ok(customerDaoImpl.getCustomerById(customerId)).build();
    }


    @Transactional
    @Override
    public Response addCustomer(Customer customer) {
        customerDaoImpl.addCustomer(customer);
        return Response.status(Response.Status.CREATED).build();
    }

    @Transactional
    @Override
    public Response updateCustomer(Customer customer) {
        customerDaoImpl.updateCustomer(customer);
        return Response.status(Response.Status.CREATED).build();
    }

    @Transactional
    @Override
    public Response removeCustomer(Customer customer) {
        customerDaoImpl.removeCustomer(customer);
        return Response.status(Response.Status.GONE).build();
    }
}
