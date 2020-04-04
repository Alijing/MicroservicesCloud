package com.jing.springcloud.config;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * Program: MicroservicesCloud
 * Date: 2019/9/12 15:00
 * Author: Jing
 * Description: https://blog.csdn.net/qq_28988969/article/details/79208797
 * https://blog.csdn.net/ihtczte/article/details/90216910
 * https://blog.csdn.net/zhengzizhi/article/details/81505900
 */
public class SQLGenerator {


    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator(); // 代码生成器
        GlobalConfig gc = new GlobalConfig(); // 全局配置
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/microservicesCloudProviderDept8001/src/main/java/");
        gc.setAuthor("Jing"); // 设置用户名
        gc.setOpen(false);
        gc.setServiceName("%sService"); // Service命名方式
        gc.setServiceImplName("%sServiceImpl"); // Service Impl 命名方式

        // 自定义文件命名，注意 %s 会自动填充表实体属性
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(false); // XML 二级缓存
        gc.setBaseResultMap(true); // XML ResultMap
        gc.setBaseColumnList(false); // XML ColumnList
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/microservices-cloud");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.jing.springcloud");
        pc.setEntity("entities");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        mpg.setPackageInfo(pc);

        // 自定义需要填充的字段
        List<TableFill> tableFills = new ArrayList<>();
        // 如 每张表都有一个创建时间、修改时间
        // 而且这基本上就是通用的了，新增时，创建时间和修改时间同时修改
        // 修改时，修改时间会修改，
        // 虽然像Mysql数据库有自动更新几只，但像ORACLE的数据库就没有了，
        // 使用公共字段填充功能，就可以实现，自动按场景更新了。
        // 如下是配置
        // TableFill createField = new TableFill("gmt_create", FieldFill.INSERT);
        // TableFill modifiedField = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);
        // tableFillList.add(createField);
        // tableFillList.add(modifiedField);

        // 自定义配置
        InjectionConfig icfg = new InjectionConfig() {
            @Override
            public void initMap() {

            }
        };
        List<FileOutConfig> focLst = new ArrayList<>();
        focLst.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/microservicesCloudProviderDept8001/src/main/resources/mapper/"
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        icfg.setFileOutConfigList(focLst);
        mpg.setCfg(icfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setTablePrefix(new String[]{"tb_system_", "tb_msc_api_"});// 此处可以修改为您的表前缀
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setSuperEntityClass("com.jing.springcloud.base.BaseEntity");
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setSuperControllerClass("com.jing.springcloud.base.BaseController");
        // 设置逻辑删除键
        strategyConfig.setLogicDeleteFieldName("deleted");
        // 指定生成bean的数据库表名
        strategyConfig.setInclude(new String[]{"tb_system_person", "tb_msc_api_dept"});
        strategyConfig.setSuperEntityColumns("id");
        // 驼峰转连字符
        strategyConfig.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategyConfig);
        // 选择freemarker 引擎需要指定如下加，注意 pom 依赖必须有
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}
