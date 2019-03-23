package com.example.springboot_jpa.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据源配置的bean
 */
@Configuration
public class DruidConfig {
    /*读取application.yml配置文件中的属性，装配到bean中*/

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }

    /**
     * Servlet注册Bean
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        //配置这个servlet的拦截页面，创建bean
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //给bean添加初始化属性
        Map<String, String> initMap = new HashMap<>();
        initMap.put("loginUsername", "admin");
        initMap.put("loginPassword", "123456");
        //允许谁访问，默认是所有
        initMap.put("allow", "");
        //拒绝谁访问
        initMap.put("deny", "192.168.111.111");
        bean.setInitParameters(initMap);
        return bean;
    }

    /**
     * 配置web监控的filter
     */
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String, String> initParams = new HashMap<>();
        initParams.put("exclusions", "*.js,*.css,/druid/*");
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Collections.singletonList("/*"));
        return bean;
    }
}
