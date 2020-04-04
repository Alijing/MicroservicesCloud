package com.jing.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: MicroservicesCloud
 * @Date: 2019/9/10 16:51
 * @Author: Jing
 * @Description:
 */
@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced  // Spring Cloud Ribbon是基于NetFlix Ribbon实现的一套客户端		均衡负载的工具
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
