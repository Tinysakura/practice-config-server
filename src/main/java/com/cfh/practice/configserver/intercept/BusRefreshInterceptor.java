package com.cfh.practice.configserver.intercept;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.InputStream;

/**
 * @Author: cfh
 * @Date: 2018/9/22 09:49
 * @Description: 拦截/actuator/bus-refresh请求
 */
@Component
@Slf4j
public class BusRefreshInterceptor implements HandlerInterceptor {

    /**
     * 在处理请求之前修改request body中的内容防止因为序列化异常导致的400错误
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String path = new String(request.getRequestURL());
        log.info("拦截请求{}", path);

        if (!path.endsWith("bus-refresh")) {
            return true;
        }

        //获取原始的body
        InputStream inputStream = request.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        byte[] bytes = new byte[bufferedInputStream.available()];
        bufferedInputStream.read(bytes, 0, bufferedInputStream.available());

        String body = new String(bytes);

        log.info("original body:{}", body);

        return false;
    }
}
