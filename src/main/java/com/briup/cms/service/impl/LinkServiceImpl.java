package com.briup.cms.service.impl;

import com.briup.cms.bean.Link;
import com.briup.cms.dao.LinkDao;
import com.briup.cms.service.ILinkService;
import com.briup.cms.util.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkServiceImpl implements ILinkService {
    @Autowired
    private LinkDao linkDao;
    @Override
    public List<Link> findAll() throws CustomerException {
        return linkDao.findAll();
    }

    @Override
    public void deleteById(int id) throws CustomerException {
        linkDao.deleteById(id);
    }

    @Override
    public Link getById(Integer id) throws CustomerException {
        return linkDao.queryById(id);
    }

    @Override
    public void saveOrUpdate(Link link) throws CustomerException {
        linkDao.save(link);
    }
}
