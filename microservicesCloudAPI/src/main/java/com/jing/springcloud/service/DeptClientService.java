package com.jing.springcloud.service;

import com.jing.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Program: MicroservicesCloud
 * Date: 2019/12/20 16:09
 * Author: Jing
 * Description:
 */
@FeignClient(value = "microservices-dept", fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @RequestMapping(value = "/dept/get/{id}")
    Dept get(@PathVariable("id") long id);

    @RequestMapping(value = "/dept/list")
    List<Dept> list();

    @RequestMapping(value = "/dept/add")
    boolean add(@RequestBody Dept dept);
}
