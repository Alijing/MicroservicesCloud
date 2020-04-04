package com.jing.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Program: MicroservicesCloud
 * Date: 2020/4/4 16:45
 * Author: Jing
 * Description:
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServer3344APP {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServer3344APP.class, args);
    }
}
