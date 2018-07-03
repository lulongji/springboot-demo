package com.example.demo.core.interceptor;

import com.llj.base.uuid.UUIDGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆过滤
 *
 * @author lu
 */
public class LoggerHandlerInterceptor implements HandlerInterceptor {
    /**
     * 日志
     */
    private static Logger logger = LogManager.getLogger(LoggerHandlerInterceptor.class.getName());

    /**
     * Handler执行完成之后调用这个方法
     */
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception exc)
            throws Exception {

    }

    /**
     * Handler执行之后，ModelAndView返回之前调用这个方法
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
    }

    /**
     * Handler执行之前调用这个方法
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        try {
            MDC.put("threadId", new UUIDGenerator().generate());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return false;
    }
}
