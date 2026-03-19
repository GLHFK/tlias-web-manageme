package com.example.tliaswebmanageme.controller;

import com.example.tliaswebmanageme.pojo.Emp;
import com.example.tliaswebmanageme.pojo.LoginData;
import com.example.tliaswebmanageme.pojo.Result;
import com.example.tliaswebmanageme.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {
    @Autowired
    private EmpService empService;

    @PostMapping("")
    public Result login(@RequestBody Emp emp) {
        return Result.success(empService.login(emp.getUsername()));
    }
}
