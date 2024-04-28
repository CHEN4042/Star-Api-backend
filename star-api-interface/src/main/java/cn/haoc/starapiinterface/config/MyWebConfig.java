package cn.haoc.starapiinterface.config;

import cn.haoc.starapiinterface.interceptor.DyeDataInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DyeDataInterceptor())
                //.addPathPatterns("/**")//拦截所有请求，而且在放行以后还会被拦截回来
                //排除路径
        .addPathPatterns("/**").excludePathPatterns(
                //放行swagger
                "/doc.html",
                "/webjars/**",
                "/swagger-resources",
                "/v3/api-docs",
                "/v2/api-docs"
        );
    }
}
