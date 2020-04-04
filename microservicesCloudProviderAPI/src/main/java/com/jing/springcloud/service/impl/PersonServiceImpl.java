package com.jing.springcloud.service.impl;

import com.jing.springcloud.entities.Person;
import com.jing.springcloud.mapper.PersonMapper;
import com.jing.springcloud.service.IPersonService;
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
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {

}
