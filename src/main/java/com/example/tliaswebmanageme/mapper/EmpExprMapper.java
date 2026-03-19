package com.example.tliaswebmanageme.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    void deleteEmpExprByIds(List<Integer> ids);
}
