package com.briup.cms.service;

import com.briup.cms.bean.Customer;
import com.briup.cms.util.CustomerException;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll() throws CustomerException;

    Customer findByName(String name) throws CustomerException;
}
