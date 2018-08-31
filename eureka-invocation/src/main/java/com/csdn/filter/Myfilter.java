package com.csdn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.stereotype.Component;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

@WebFilter(urlPatterns = "/*", filterName = "hystrixFilter")
@Component
public class Myfilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
            FilterChain filterChain) throws IOException, ServletException {

        System.out.println("===================MyFilter====================");
        // 初始化 hystrix 请求上下文
        HystrixRequestContext hystrixRequestContext = HystrixRequestContext.initializeContext();

        /* 业务逻辑 */

        try{
            filterChain.doFilter(servletRequest, servletResponse);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            hystrixRequestContext.shutdown();
        }
    }

    @Override
    public void destroy() {}

}
