package com.briup.cms.web.controller;

import com.briup.cms.bean.Link;
import com.briup.cms.service.ILinkService;
import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/link")
public class LinkController  {
    @Autowired
    private ILinkService linkService;

    @GetMapping("/get")
    public Message getAll() {
        return MessageUtil.success(linkService.findAll());
    }

    @GetMapping("/deleteById")
    public Message deleteById(Integer id) {
        linkService.deleteById(id);
        return MessageUtil.success();
    }

    @GetMapping("/getById")
    public Message getById(Integer id) {
        return MessageUtil.success(linkService.getById(id));
    }

    @PostMapping("/updateById")
    public Message  updateById(Link link) {
        linkService.saveOrUpdate(link);
        return MessageUtil.success();
    }

    @PostMapping("/save")
    public Message  save(Link link) {
        linkService.saveOrUpdate(link);
        return MessageUtil.success();
    }
}
