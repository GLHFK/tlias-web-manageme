package com.example.tliaswebmanageme.interceptor;

import com.example.tliaswebmanageme.Utils.JWTUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Slf4j
public class Interceptor implements HandlerInterceptor {
    private static int count = 0;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("拦截{}", requestURI);
        if (requestURI.contains("login")) {
            log.info("登录");
            return true;
        }
        String token = request.getHeader("token");
        if (token == null || token.length() == 0) {
            log.info("token为空");
            return false;
        }
        try {
            JWTUtils.parseJWT(token);
        } catch (Exception e) {
            log.info("token错误");
            return false;
        }
        log.info("token正确");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        log.info("第{}次拦截结束", ++count);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        log.info("关闭拦截");
    }
}
