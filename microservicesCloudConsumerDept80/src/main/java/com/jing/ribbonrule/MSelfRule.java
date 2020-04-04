package com.jing.ribbonrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Program: MicroservicesCloud
 * Date: 2019/12/18 15:04
 * Author: Jing
 * Description:
 * 官方文档明确的给出了警告：
 * 这个自定义配置类不能放在 @ComponentScan 所扫描的当前包以及其子包下面，
 * 否则我们自定义的配置类就会被所有的 Ribbon 客户端共享，也就达不到我们特殊化定制的目的了。
 */
@Configuration
public class MSelfRule {
    @Bean
    public IRule setLBRule() {
        return new MRandomRule(); // 用随机算法替代默认的轮询算法
    }
}
