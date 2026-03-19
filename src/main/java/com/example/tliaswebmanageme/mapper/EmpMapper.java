package com.example.tliaswebmanageme.mapper;

import com.example.tliaswebmanageme.pojo.Emp;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {


/*    @Select("select count(*) from emp left join dept on emp.dept_id = dept.id ")
    Long count();

    @Select("select e.id, e.username, e.password, e.name, e.gender, e.phone, e.job, e.salary, e.image, e.entry_date, e.dept_id, e.create_time, e.update_time, d.name as dept_name from emp e left join dept d on e.dept_id = d.id limit #{index},#{pageSize}")
    List<Emp> selectPage(int index, int pageSize);*/

    /*@Select("select e.id, e.username, e.password, e.name, e.gender, e.phone, e.job, e.salary, e.image, e.entry_date, e.dept_id, e.create_time, e.update_time, d.name as dept_name from emp e left join dept d on e.dept_id = d.id " +
            "where e.name like concat('%',#{name},'%')and e.gender =#{gender} and e.entry_date between #{begin} and #{end}  order by e.update_time desc")*/
    @Options(useGeneratedKeys = true, keyColumn = "id")
    List<Emp> selectPage(String name, Integer gender, LocalDate begin, LocalDate end);

    void deleteByIds(List<Integer> ids);

    @Options(useGeneratedKeys = true, keyColumn = "id")
    Emp findById(Integer id);

    void insertIntoEmp(Emp emp);

    void insertIntoEmpExpr(Emp emp);

    Emp login(String username);
}

