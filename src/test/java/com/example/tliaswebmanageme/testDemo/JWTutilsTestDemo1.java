package com.example.tliaswebmanageme.testDemo;

import com.example.tliaswebmanageme.Utils.JWTUtils;
import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@Slf4j
public class JWTutilsTestDemo1 {
    public static String code = "LIUHUA";
    @Autowired
    private JWTUtils jwtUtils;

    @Test
    public void JWTUtilsGetTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("username", "admin");
        String token = jwtUtils.creatJWT(map);
        log.info(token);
    }

    @Test
    public void JWTUtilsParseTest(String token) {
        Map<String, Object> map = jwtUtils.parseJWT(token);
        log.info(map.toString());
    }
}
