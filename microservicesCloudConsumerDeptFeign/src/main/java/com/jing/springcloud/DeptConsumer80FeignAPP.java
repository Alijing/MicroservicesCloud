package com.jing.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @program: MicroservicesCloud
 * @Date: 2019/9/10 17:21
 * @Author: Jing
 * @Description:
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.jing.springcloud"})
@ComponentScan("com.jing.springcloud")
public class DeptConsumer80FeignAPP {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80FeignAPP.class, args);
    }

}
