//package com.jing.springcloud.entities;
//
//import com.baomidou.mybatisplus.annotation.TableField;
//import com.baomidou.mybatisplus.annotation.TableName;
//import com.jing.springcloud.base.BaseEntity;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.experimental.Accessors;
//
//import java.io.Serializable;
//
///**
// * <p>
// *
// * </p>
// *
// * @author Jing
// * @since 2019-09-12
// */
//@Data
//@EqualsAndHashCode(callSuper = true)
//@Accessors(chain = true)
//@TableName("tb_msc_api_dept")
//public class Dept extends BaseEntity<Dept> {
//
//    private static final long serialVersionUID = 1L;
//
//    private long id;
//
//    /**
//     * 部门名称
//     */
//    private String name;
//
//    /**
//     * 上级ID
//     */
//    @TableField("parentId")
//    private Long parentId;
//
//    /**
//     * 备注
//     */
//    @TableField("`desc`")
//    private String desc;
//
//    /**
//     * 来自哪一个数据库
//     */
//    @TableField("dbSource")
//    private String dbSource;
//
//    protected Serializable pkVal() {
//        return null;
//    }
//
//}
