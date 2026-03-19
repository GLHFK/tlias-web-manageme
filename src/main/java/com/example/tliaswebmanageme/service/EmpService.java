package com.example.tliaswebmanageme.service;


import com.example.tliaswebmanageme.pojo.Emp;
import com.example.tliaswebmanageme.pojo.LoginData;
import com.example.tliaswebmanageme.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

    /*    Long count();*/

    PageResult<Emp> selectPage(String name, Integer gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize);

    void delete(List<Integer> ids);

    Emp findById(Integer id);

    void update(Emp emp);

    LoginData login(String username);
}
