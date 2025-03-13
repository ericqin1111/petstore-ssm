package org.csu.petstoredev.config;

//import org.csu.petstoredev.interceptor.LogInterceptor;
import jakarta.annotation.PostConstruct;
import org.csu.petstoredev.interceptor.LogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("org.csu.petstoredev.interceptor")

public class WebConfig implements WebMvcConfigurer {

    @Autowired
    LogInterceptor logInterceptor;

    @PostConstruct
    public void init() {
        System.out.println("WebConfig 初始化成功2");
    }



    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(logInterceptor)
                .addPathPatterns("/**")
                        .order(1);

        System.out.println("拦截器已注册");

    }
}
