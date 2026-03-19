package com.example.tliaswebmanageme.controller;

import com.example.tliaswebmanageme.pojo.Emp;
import com.example.tliaswebmanageme.pojo.PageResult;
import com.example.tliaswebmanageme.pojo.Result;
import com.example.tliaswebmanageme.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping("/emps")
    public Result findByPage(@RequestParam(value = "name", required = false) String name,
                             @RequestParam(value = "gender", required = false) Integer gender,
                             @RequestParam(value = "begin", required = false) LocalDate begin,
                             @RequestParam(value = "end", required = false) LocalDate end,
                             @RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        log.info("page:{},pageSize:{}", page, pageSize);
        PageResult<Emp> empList = empService.selectPage(name, gender, begin, end, page, pageSize);
        log.info(empList.toString());
        return Result.success(empList);
    }

    /*  @DeleteMapping("/emps")
        public Result delete(Integer[] id){
            log.info("ID:{}", Arrays.toString(id));
            return Result.success();
        }*/
    @DeleteMapping("/emps")
    public Result delete(@RequestParam List<Integer> ids) {
        log.info("ID:{}", ids.toString());
        empService.delete(ids);
        return Result.success();
    }

    @GetMapping("/emps/{id}")
    public Result findById(@PathVariable Integer id) {
        Emp emp = empService.findById(id);
        return Result.success(emp);
    }

    @PutMapping("/emps")
    public Result update(@RequestBody Emp emp) {
        empService.update(emp);
        return Result.success();
    }
}
