package com.jing.springcloud.cotroller;

import com.jing.springcloud.entities.Dept;
import com.jing.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: MicroservicesCloud
 * @Date: 2019/9/10 16:57
 * @Author: Jing
 * @Description:
 */
@RestController
@RequestMapping(value = "/consumer/dept")
public class DeptConsumerController {

    @Autowired
    private DeptClientService service;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return this.service.add(dept);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") long id) {
        return this.service.get(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Dept> list() {
        return this.service.list();
    }


}
