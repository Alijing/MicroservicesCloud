package com.jing.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Program: MicroservicesCloud
 * Date: 2019/9/17 17:00
 * Author: Jing
 * Description:
 */
@SpringBootApplication
@EnableEurekaServer  // Eureka Server 服务启动类，接收其他微服务来进行注册
public class EurekaServer7001APP {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7001APP.class, args);
    }

}
