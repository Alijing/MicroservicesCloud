package com.jing.springcloud.service.impl;

import com.jing.springcloud.entities.Dept;
import com.jing.springcloud.mapper.DeptMapper;
import com.jing.springcloud.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jing
 * @since 2019-09-17
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

}
