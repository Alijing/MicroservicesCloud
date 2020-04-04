package com.jing.springcloud.controller;


import com.jing.springcloud.entities.Dept;
import com.jing.springcloud.service.DeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Jing
 * @since 2019-09-12
 */
@RestController
@RequestMapping(value = "/dept")
public class DeptController {
    private static final Logger logger = LoggerFactory.getLogger(DeptController.class);
    @Autowired
    DeptService service;

    @Autowired
    DiscoveryClient client;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return service.save(dept);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") long id) {
        return service.getById(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Dept> list() {
        return service.list();
    }

    @RequestMapping(value = "/discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> services = client.getServices();
        logger.info(services.toString());
        List<ServiceInstance> instances = client.getInstances("microservices-dept");
        for (ServiceInstance ele : instances) {
            logger.info(ele.getServiceId() + ", " + ele.getHost() + ", " + ele.getPort() + ", " + ele.getUri());
        }
        return client;
    }


}
