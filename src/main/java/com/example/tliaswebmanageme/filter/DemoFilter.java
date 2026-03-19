package com.example.tliaswebmanageme.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
//@WebFilter("/*")
public class DemoFilter implements Filter {
    private static int count = 0;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("启动拦截...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("拦截次数 ：{}", ++count);
        if (count == 10) {
            log.info("拦截结束...");
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        log.info("关闭拦截...");
    }
}
