package com.example.demo.core.interceptor;

import com.llj.base.uuid.UUIDGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * 日志MDC
 *
 * @author lu
 */
@Component
public class LogInterceptor implements HandlerInterceptor {
    /**
     * 日志
     */
    private static Logger logger = LoggerFactory.getLogger(LogInterceptor.class.getName());

    private final static String REQUEST_ID = "requestId";


    /**
     * Handler执行之前调用这个方法
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String xForwardedForHeader = request.getHeader("X-Forwarded-For");
        String remoteIp = request.getRemoteAddr();
        String uuid = String.valueOf(UUID.randomUUID());
        logger.info("put requestId ({}) to logger", uuid);
        logger.info("request id:{}, client ip:{}, X-Forwarded-For:{}", uuid, remoteIp, xForwardedForHeader);
        MDC.put(REQUEST_ID, uuid);
        return true;
    }

    /**
     * Handler执行之后，ModelAndView返回之前调用这个方法
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        String uuid = MDC.get(REQUEST_ID);
        logger.info("remove requestId ({}) from logger", uuid);
        MDC.remove(REQUEST_ID);
    }

    /**
     * Handler执行完成之后调用这个方法
     */
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception exc)
            throws Exception {

    }


}
