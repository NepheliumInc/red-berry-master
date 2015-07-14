package com.redberry.mvc.service;

import com.redberry.mvc.dao.CustomerDao;
import com.redberry.mvc.hbnt.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Amila on 7/13/15.
 */
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Transactional
    @Override
    public Customer getCustomerById(int id) {
        return customerDao.getCustomerById(id);
    }
}
