package com.jing.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

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
@EnableCircuitBreaker // 对 Hystrix 熔断机制的支持
public class DeptProviderHystrix8001APP {


    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registration.addUrlMappings("/hystrix.stream");
        return registration;
    }

    public static void main(String[] args) {
        SpringApplication.run(DeptProviderHystrix8001APP.class, args);
    }
}
