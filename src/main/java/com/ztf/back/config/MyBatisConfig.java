package com.ztf.back.config;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.Properties;

/**
 * ClassName:MyBatisConfig
 * Package:IntelliJ IDEA
 * Description:
 *
 * @Author ztf
 * @Create 2025/5/29-18:31
 * @Version 1.0
 */
@Configuration
public class MyBatisConfig {

    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");  // 根据数据库类型选择
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "true");
        pageHelper.setProperties(properties);
        return pageHelper;
    }

    @Bean
    @Order(0) // 设置高优先级
    public PageInterceptor pageInterceptor() {
        return new PageInterceptor();
    }
}
