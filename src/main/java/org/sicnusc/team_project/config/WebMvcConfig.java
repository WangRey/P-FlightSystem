package org.sicnusc.team_project.config;

import org.sicnusc.team_project.config.Interceptor_config.Login_Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/error")
                .excludePathPatterns("/login/*")
                .excludePathPatterns("/register/*")
                .excludePathPatterns("/flight/*")
                .excludePathPatterns("/test/login")
        ;
    }
    @Bean
    public static  HandlerInterceptor getHandlerInterceptor() {
        return new Login_Interceptor();
    }
}
