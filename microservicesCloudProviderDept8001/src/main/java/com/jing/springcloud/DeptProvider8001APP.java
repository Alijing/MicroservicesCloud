package com.jing.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: MicroservicesCloud
 * @Date: 2019/9/10 16:04
 * @Author: Jing
 * @Description:
 */
@SpringBootApplication
@MapperScan("com.jing.springcloud.mapper")
@EnableEurekaClient // 本服务启动后会注册到 Eureka 服务中
@EnableDiscoveryClient // 服务发现
public class DeptProvider8001APP {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8001APP.class, args);
    }
}
