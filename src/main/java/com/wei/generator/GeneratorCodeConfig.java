package com.wei.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @ClassName:GeneratorCode
 * @Description: ToDo
 * @Author: pengwei
 * @Date:2018/12/7 17:11
 * @Version: 1.0
 */
@Configuration
public class GeneratorCodeConfig {
    @Bean
    public AutoGenerator getAutoGenerator(){
        AutoGenerator mpg = new AutoGenerator();
        /**
         * 设置全局配置
         */
        mpg.setGlobalConfig(getGlobalConfig());
        /**
         * 设置数据源
         */

        mpg.setDataSource(getDataSourceConfig());
        /**
         * 设置策略配置
         */
        mpg.setStrategy(getStrategyConfig());
        /**
         * 设置包配置
         */
        mpg.setPackageInfo(getPackageConfig());

        /**
         * 设置注入自定义配置
         */
        mpg.setCfg(getInjectionConfig());
        return  mpg;
    }

    @Bean
    public StrategyConfig getStrategyConfig() {
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名
        // strategy.setDbColumnUnderline(true);//全局下划线命名
//		strategy.setTablePrefix(new String[] { "bmd_", "mp_" });// 此处可以修改为您的表前缀
        /**表名生成策略*/
        strategy.setNaming(NamingStrategy.underline_to_camel);
       // strategy.setInclude(new String[]{"user"}); // 需要生成的表
        // strategy.setExclude(new String[]{"test"}); // 排除生成的表
        // 自定义实体父类
        // strategy.setSuperEntityClass("com.baomidou.demo.TestEntity");
        // 自定义实体，公共字段
        // strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
        // 自定义 mapper 父类
        // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
        // 自定义 service 父类
        // strategy.setSuperServiceClass("com.baomidou.demo.TestService");
        // 自定义 service 实现类父类
        // strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
        // 自定义 controller 父类
        strategy.setSuperControllerClass("com.wei.controller.base.BaseController");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // strategy.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        // strategy.setEntityBuliderModel(true);
        /**
         * 获取配置文件
         *
         * @return 配置Props
         */
        return strategy;
    }
    @Bean
    private static Properties getProperties() {
        // 读取配置文件
        Resource resource = new ClassPathResource("/application-dev.yml");
        Properties props = new Properties();
        try {
            props = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }

    /**
     * 注入自定义配置
     * @return
     */
    @Bean
    public InjectionConfig getInjectionConfig() {
        String viewOutputDir = "F:\\codege\\view\\";
        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };
        // 生成的模版路径，不存在时需要先新建
        File viewDir = new File(viewOutputDir);
        if (!viewDir.exists()) {
            viewDir.mkdirs();
        }
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        focList.add(new FileOutConfig("/generator/add.jsp.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return getGeneratorViewPath(viewOutputDir, tableInfo, "Add.jsp");
            }
        });
        focList.add(new FileOutConfig("/generator/edit.jsp.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return getGeneratorViewPath(viewOutputDir, tableInfo, "Edit.jsp");
            }
        });
        focList.add(new FileOutConfig("/generator/list.jsp.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return getGeneratorViewPath(viewOutputDir, tableInfo, "List.jsp");
            }
        });
        cfg.setFileOutConfigList(focList);
        return cfg;
    }
    @Bean
    public DataSourceConfig getDataSourceConfig() {
     /* 获取 JDBC 配置文件 */
        Properties props = getProperties();
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert());
        dsc.setDriverName(props.getProperty("geDriver"));
        dsc.setUsername(props.getProperty("geUsername"));
        dsc.setPassword(props.getProperty("gePassword"));
        dsc.setUrl(props.getProperty("geUrl"));
        return  dsc;
    }
    /**
     * 包配置
     * @return
     */
    @Bean
    public PackageConfig getPackageConfig() {
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(null);  //所属模块
        pc.setParent("com.wei"); // 自定义包路径
        pc.setController("controller"); // 这里是控制器包名，默认 web
        pc.setEntity("model");
        pc.setXml("sqlMapperXml");
        return pc;
    }

    /**
     *  全局配置
     * @return
     */
    @Bean
    public GlobalConfig getGlobalConfig() {
        String outputDir = "F:\\codege";
        GlobalConfig gc = new GlobalConfig();
        File Dir = new File(outputDir);
        if (!Dir.exists()) {
            Dir.mkdirs();
        }
        gc.setOutputDir(outputDir);
        gc.setFileOverride(true);
        gc.setActiveRecord(true);// 开启 activeRecord 模式
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("wei.peng");
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("I%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        return gc;
    }

    /**
     * 页面生成的文件名
     */
    private static String getGeneratorViewPath(String viewOutputDir, TableInfo tableInfo, String suffixPath) {
        String name = StringUtils.firstToLowerCase(tableInfo.getEntityName());
        String path = viewOutputDir + "/" + name + "/" + name + suffixPath;
        File viewDir = new File(path).getParentFile();
        if (!viewDir.exists()) {
            viewDir.mkdirs();
        }
        return path;
    }
}
