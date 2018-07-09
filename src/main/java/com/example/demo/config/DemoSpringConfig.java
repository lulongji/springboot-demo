package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @Description:自定义拦截器
 * @Author: lulongji
 */

@Configuration
public class DemoSpringConfig extends WebMvcConfigurationSupport {


    /**
     * 解决跨域问题
     **/
    @Override
    public void addCorsMappings(CorsRegistry registry) {

    }

    /**
     * 添加拦截器
     **/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //日志拦截器
        //registry.addInterceptor(new LogInterceptor());
        //super.addInterceptors(registry);
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        //registry.addInterceptor(new LoggerHandlerInterceptor()).addPathPatterns("api/path/**").excludePathPatterns("api/path/login");
    }

    /**
     * 配置视图解析器
     **/
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.freeMarker();
        registry.enableContentNegotiation(new MappingJackson2JsonView());
    }

    /**
     * 配置内容裁决的一些选项
     **/
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false)
                .ignoreAcceptHeader(true)
                .parameterName("mediaType")
                .defaultContentType(MediaType.TEXT_HTML)
                .mediaType("html", MediaType.TEXT_HTML)
                .mediaType("json", MediaType.APPLICATION_JSON);
    }

    /**
     * 视图跳转控制器
     **/
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

    }

    /**
     * 静态资源处理
     **/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    /**
     * 默认静态资源处理器
     **/
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
        super.configureDefaultServletHandling(configurer);
    }


    @Override
    public void configureMessageConverters(
            List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(responseBodyConverter());
    }

    /**
     * 解决中文乱码
     */
    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(
                Charset.forName("UTF-8"));
        return converter;
    }


}
