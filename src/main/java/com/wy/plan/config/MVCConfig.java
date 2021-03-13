package com.wy.plan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author WangYao
 * @date 2021/3/1
 * @function mvc配置
 */
@Configuration
public class MVCConfig implements WebMvcConfigurer {
    /**
     * 首页
     * @param registry 视图控制器
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("commons/thingsCommon");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**").excludePathPatterns("/","/index.html","/user/login","/js/**","/css/**","/img/**");
    }

    /**
     * 自定义国际化
     * @return 自己的国际化
     */
    @Bean
    public NewLocaleResolver localeResolver(){
        return new NewLocaleResolver();
    }


}
