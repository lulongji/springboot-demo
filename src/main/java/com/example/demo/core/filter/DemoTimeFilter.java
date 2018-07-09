package com.example.demo.core.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Date;

/**
 * @Description: 时间过滤器
 * @Author: lulongji
 */

// 加入spring ioc容器
@Component
/*
 * @WebFilter将一个实现了javax.servlet.Filter接口的类定义为过滤器
 * 属性filterName声明过滤器的名称,可选
 * 属性urlPatterns指定要过滤 的URL模式,也可使用属性value来声明.(指定要过滤的URL模式是必选属性)
 */
@WebFilter(filterName = "DemoTimeFilter", urlPatterns = "/*")
//指定过滤器的执行顺序,值越大越先执行
@Order(1)
public class DemoTimeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter初始化成功了");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Long time = new Date().getTime();
        System.out.println("Filter方法执行前时间:" + time);
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Filter方法执行后时间:" + new Date().getTime() + ",共耗时:" + (new Date().getTime() - time));
    }

    @Override
    public void destroy() {
        System.out.println("Filter销毁了");
    }


}
