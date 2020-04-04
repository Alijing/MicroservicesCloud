package com.jing.springcloud.service;

import com.jing.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Program: MicroservicesCloud
 * Date: 2020/3/27 11:03
 * Author: Jing
 * Description:
 */
@Component // 千万别忘记加
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept get(long id) {
                return new Dept().setId(id).setName("该id : " + id + "在数据库中不存在，" +
                        "Consumer客户端提供的降级信息，此刻服务Provider已经关闭").setDbSource("No this database in MySQL");
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
    }
}
