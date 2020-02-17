package com.briup.cms.service.impl;

import com.briup.cms.bean.Customer;
import com.briup.cms.dao.CustomerDao;
import com.briup.cms.service.ICustomerService;
import com.briup.cms.util.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private CustomerDao customerDao;

    public List<Customer> findAll() throws CustomerException {
        return customerDao.findAll();
    }

    @Override
    public Customer findByName(String name) throws CustomerException {
        return customerDao.findByUsernameEquals(name);
    }
}
