package com.lord.advertis.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *   登录配置
 * “WebSecurityConfig”类继承“WebMvcConfigurerAdapter”，
 *  重新“addInterceptors”方法，其目的是设置拦截规则，
 *  excludePathPatterns为需要排除的规则，addPathPatterns为需要拦截的规则。
 */
@Configuration
public class WebSecurityConfig extends WebMvcConfigurerAdapter {

    /**
     * 登录session key
     */
    public final static String SESSION_KEY = "user";

    @Bean
    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }

    /**
     *  设置拦截规则
     */
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());

        // 排除配置
        addInterceptor.excludePathPatterns("/error");
        addInterceptor.excludePathPatterns("/manager/browse/add");
        addInterceptor.excludePathPatterns("/manager/customers/add");
        addInterceptor.excludePathPatterns("/manager/user/login**");

        // 拦截配置
        addInterceptor.addPathPatterns("/manager/**");
    }

    /**
     * “SecurityInterceptor”类继承“HandlerInterceptorAdapter”，
     * 并重新“preHandle”方法，当session为空时，则跳转到登录页面
     */
    private class SecurityInterceptor extends HandlerInterceptorAdapter {

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                throws Exception {
            HttpSession session = request.getSession();
            if (session.getAttribute(SESSION_KEY) != null) {
                return true;
            }

            // 跳转登录
            String url = "/manager/user/login";
            response.sendRedirect(url);
            return false;
        }
    }
}