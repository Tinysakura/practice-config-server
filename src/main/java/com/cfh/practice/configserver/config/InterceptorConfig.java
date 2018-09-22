package com.cfh.practice.configserver.config;

import com.cfh.practice.configserver.intercept.BusRefreshInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: cfh
 * @Date: 2018/9/22 10:06
 * @Description:
 */
@Configuration
@Slf4j
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    BusRefreshInterceptor busRefreshInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("添加对/actuator/bus-refresh节点的拦截");
        registry.addInterceptor(busRefreshInterceptor).addPathPatterns("/actuator/bus-refresh");
    }
}
