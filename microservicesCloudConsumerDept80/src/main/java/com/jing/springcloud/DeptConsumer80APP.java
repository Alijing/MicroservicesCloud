package com.jing.springcloud;

import com.jing.ribbonrule.MSelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @program: MicroservicesCloud
 * @Date: 2019/9/10 17:21
 * @Author: Jing
 * @Description:
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
// 在启动微服务的时候就能去加载我们自定义的Ribbon配置类，从而使配置生效
@RibbonClient(name = "microservices-dept", configuration = MSelfRule.class)
public class DeptConsumer80APP {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80APP.class, args);
    }

}
