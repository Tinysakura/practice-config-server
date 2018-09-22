package com.cfh.practice.configserver.config;

import com.cfh.practice.configserver.filter.BusRefreshFilter;
import com.cfh.practice.configserver.intercept.BusRefreshInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: cfh
 * @Date: 2018/9/22 10:49
 * @Description: 配置过滤器
 */
@Configuration
@Slf4j
public class FilterConfig{

    @Bean
    public FilterRegistrationBean busRefreshFilter(){
        log.info("注入BusRefreshFilter");
        FilterRegistrationBean registration = new FilterRegistrationBean();
        BusRefreshFilter busRefreshFilter = new BusRefreshFilter();

        registration.setFilter(busRefreshFilter);
        registration.addUrlPatterns("/*");

        return registration;
    }
}
