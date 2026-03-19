package com.example.tliaswebmanageme.controller;

import com.example.tliaswebmanageme.pojo.Dept;
import com.example.tliaswebmanageme.pojo.Result;
import com.example.tliaswebmanageme.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    private static final Logger logger = LoggerFactory.getLogger(DeptController.class);
    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    public Result findAll() {
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    /*    @DeleteMapping("/depts")
        public Result delete(@RequestParam(value = "id",required = true)Integer id){
            deptService.delete(id);
            System.out.println(id);
            return Result.success();
        }*/
/*    @DeleteMapping("/depts")
    public Result delete(HttpServletRequest request){
        String idstr =request.getParameter("id");
        Integer id =Integer.parseInt(idstr);
        deptService.delete(id);
        return Result.success();
    }*/
    @DeleteMapping("/depts")
    public Result delete(Integer id) {
        deptService.delete(id);
        logger.info(Integer.toString(id));
        return Result.success();
    }

    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept) {
        deptService.add(dept);
        System.out.println(dept);
        return Result.success();
    }

    @GetMapping("/depts/{id}")
    public Result findById(@PathVariable("id") Integer id) {
        System.out.println("11111111" + id);
        Dept dept = deptService.findById(id);
        return Result.success(dept);
    }

    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept) {
        deptService.update(dept);
        return Result.success();
    }
}
