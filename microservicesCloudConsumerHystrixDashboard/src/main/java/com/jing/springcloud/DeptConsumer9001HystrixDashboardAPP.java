package com.jing.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @program: MicroservicesCloud
 * @Date: 2019/9/10 17:21
 * @Author: Jing
 * @Description:
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableHystrixDashboard
public class DeptConsumer9001HystrixDashboardAPP {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer9001HystrixDashboardAPP.class, args);
    }

}
