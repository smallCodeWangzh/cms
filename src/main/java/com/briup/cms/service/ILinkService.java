package com.briup.cms.service;

import com.briup.cms.bean.Link;
import com.briup.cms.util.CustomerException;

import java.util.List;

public interface ILinkService {
    List<Link> findAll() throws CustomerException;

    void deleteById(int id) throws CustomerException;

    Link getById(Integer id) throws  CustomerException;

    void saveOrUpdate(Link link) throws  CustomerException;
}
