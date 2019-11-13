package com.yidiandian.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/10/9 17:28
 * @Email: 15290810931@163.com
 */
@Configuration
public class LoginInterceptorConfig implements WebMvcConfigurer {

    @Bean
    public LoginInterceptor createLoginInterceptor(){
        return new LoginInterceptor();
    }
    //增加拦截器方法
    public void addInterceptors(InterceptorRegistry registry){
        InterceptorRegistration addInterceptor = registry.addInterceptor(createLoginInterceptor());
       /* addInterceptor.addPathPatterns("/**");*/
        //排除一些访问,不拦截
        //去登录
        addInterceptor.excludePathPatterns("/toLogin");
        //[底部链接相关]
        addInterceptor.excludePathPatterns("/lineAboutWeb");
        addInterceptor.excludePathPatterns("/linkCommonly");
        addInterceptor.excludePathPatterns("/linkUS");
        addInterceptor.excludePathPatterns("/followUS");
        addInterceptor.excludePathPatterns("/footer");
        addInterceptor.excludePathPatterns("/head");


        addInterceptor.excludePathPatterns("/login");
        addInterceptor.excludePathPatterns("/toReg");
        addInterceptor.excludePathPatterns("/regSave");
        addInterceptor.excludePathPatterns("/defaultKaptcha");
        addInterceptor.excludePathPatterns("/validateDefaultKaptcha");

        addInterceptor.excludePathPatterns("/dist/css/*.css");
        addInterceptor.excludePathPatterns("/dist/data/*.json");
        addInterceptor.excludePathPatterns("/dist/img/*.png");
        addInterceptor.excludePathPatterns("/dist/layer/*.js");
        addInterceptor.excludePathPatterns("/dist/js/*.js");
        addInterceptor.excludePathPatterns("/dist/layer/mobile/need/*.css");
        addInterceptor.excludePathPatterns("/dist/layer/theme/default/*.png");
        addInterceptor.excludePathPatterns("/dist/layer/theme/default/*.css");
        addInterceptor.excludePathPatterns("/dist/layer/theme/default/*.gif");
        addInterceptor.excludePathPatterns("/dist/img/*.ico");
        addInterceptor.excludePathPatterns("/dist/plugins/**/*");

  /*addInterceptor.excludePathPatterns("/cookie");
  addInterceptor.excludePathPatterns("/getcookie");*/
    }

}
