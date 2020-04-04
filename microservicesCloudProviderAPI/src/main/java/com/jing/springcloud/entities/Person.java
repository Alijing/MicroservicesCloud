package com.jing.springcloud.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.jing.springcloud.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jing
 * @since 2019-09-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tb_system_person")
public class Person extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long uid;

    private String name;

    private Integer sex;

    private String phone;

    private String tel;

    private String email;

    private String qq;

    private String weixin;

    private String address;

    private LocalDateTime birthday;

    private String nativePlace;

    private Integer nationId;

    private Integer edu;

    private Integer professional;

    private Integer marital;

    private String desc;


}
