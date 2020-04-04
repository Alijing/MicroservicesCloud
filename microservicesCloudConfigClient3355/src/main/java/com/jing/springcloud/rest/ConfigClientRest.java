package com.jing.springcloud.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Program: MicroservicesCloud
 * Date: 2020/4/4 17:53
 * Author: Jing
 * Description:
 */
@RestController
public class ConfigClientRest {

    @Value("${spring.application.name}")
    private String appName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServices;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String getConfig() {
        String str = "appName : " + appName + ", port : " + port + ", eurekaServices : " + eurekaServices;
        System.out.println("-- >>>> [ getConfig ] " + str);
        return "appName : " + appName + ", port : " + port + ", eurekaServices : " + eurekaServices;
    }
}
