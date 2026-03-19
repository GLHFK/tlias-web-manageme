package com.example.tliaswebmanageme.service.impl;

import com.example.tliaswebmanageme.Utils.JWTUtils;
import com.example.tliaswebmanageme.mapper.EmpExprMapper;
import com.example.tliaswebmanageme.mapper.EmpMapper;

import com.example.tliaswebmanageme.pojo.Emp;
import com.example.tliaswebmanageme.pojo.LoginData;
import com.example.tliaswebmanageme.pojo.PageResult;
import com.example.tliaswebmanageme.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.DeprecatedConfigurationProperty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
@Scope("singleton")
public class EmpServiceImpl implements EmpService {
    @Value("1")
    private int text;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;

    /*    @Override
        public Long count() {
            Long count = empMapper.count();
            return count;
        }*/
    @PostConstruct
    public void init() {
        System.out.println("init_EmpServiceImpl...");
    }

    @PreDestroy
    public void destory() {
        System.out.println("destory_EmpServiceImpl...");
    }

    @Transactional(rollbackFor = {Exception.class}, propagation = Propagation.REQUIRES_NEW)
    @Override
    public PageResult<Emp> selectPage(String name, Integer gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize) {

        PageHelper.startPage(page, pageSize);
        List<Emp> emp = empMapper.selectPage(name, gender, begin, end);
        Page<Emp> empPage = (Page<Emp>) emp;
        return new PageResult<Emp>(empPage.getTotal(), empPage.getResult());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(List<Integer> ids) {
        empMapper.deleteByIds(ids);
        empExprMapper.deleteEmpExprByIds(ids);
    }

    @Override
    public Emp findById(Integer id) {
        Emp emp = empMapper.findById(id);
        log.info(emp.toString());
        return emp;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Emp emp) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(emp.getId());
        emp.setUpdateTime(LocalDateTime.now());
        Emp emp1 = emp;
        empMapper.deleteByIds(list);
        empMapper.insertIntoEmp(emp1);
        if (!CollectionUtils.isEmpty(emp1.getExprList())) {
            emp1.getExprList().forEach(empExpr -> empExpr.setEmpId(emp1.getId()));
        }
        empMapper.insertIntoEmpExpr(emp1);
    }

    @Override
    public LoginData login(String username) {
        Emp emp = empMapper.login(username);
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("id", emp.getId());
        dataMap.put("username", emp.getUsername());
        String token = JWTUtils.creatJWT(dataMap);
        log.info(token);
        return new LoginData(emp.getId(), emp.getUsername(), emp.getPassword(), token);
    }
}
