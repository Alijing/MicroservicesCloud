package com.jing.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Program: MicroservicesCloud
 * Date: 2019/9/17 17:00
 * Author: Jing
 * Description:
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableZuulProxy
public class ZuulGateway9527APP {

    public static void main(String[] args) {
        SpringApplication.run(ZuulGateway9527APP.class, args);
    }

}
