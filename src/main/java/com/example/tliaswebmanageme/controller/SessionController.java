package com.example.tliaswebmanageme.controller;

import com.example.tliaswebmanageme.pojo.Result;
import jakarta.servlet.http.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SessionController {
    @GetMapping("/session1")
    public Result getCookie(HttpServletRequest request) {
        log.info(request.toString());
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login")) {
                log.info("cookie:{}", cookie.getValue());
            }
        }
        return Result.success(cookies);
    }

    @GetMapping("/session2")
    public Result setCookie(HttpServletResponse response) {
        log.info(response.toString());
        response.addCookie(new Cookie("login", "12313131"));
        return Result.success();
    }

    @GetMapping("/session3")
    public Result getSession(HttpSession request) {
        log.info("request : {}", request.hashCode());
        Object login = request.getAttribute("login2");
        log.info("session:{}", login);
        return Result.success(login);
    }

    @GetMapping("/session4")
    public Result setSession(HttpSession response) {
        log.info("request : {}", response.hashCode());
        response.setAttribute("login2", "xxxxxxxx");
        log.info("session:{}", response.getAttribute("login2"));
        return Result.success();
    }
}
