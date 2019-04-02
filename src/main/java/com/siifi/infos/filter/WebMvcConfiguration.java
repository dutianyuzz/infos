/*
package com.siifi.infos.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

*/
/**
 * 登录拦截
 *//*


@Configuration`
public class WebMvcConfiguration implements WebMvcConfigurer {

    private final Logger logger = LoggerFactory.getLogger(WebMvcConfiguration.class);

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("add interceptors");
        registry.addInterceptor(new MyInterceptor()).excludePathPatterns(Arrays.asList("/infos/login","/infos/index","/static/**","/infos/verify"));
    }
}
*/
