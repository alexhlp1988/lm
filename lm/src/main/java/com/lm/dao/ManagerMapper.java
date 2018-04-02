package com.lm.dao;

import com.lm.condition.ManagerCondition;
import com.lm.pojo.Manager;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ManagerMapper {
    //分页查询
    List<Manager> findPage(ManagerCondition managerCondition);
    //分页数据总数
    int findPageTotal(ManagerCondition managerCondition);
    //根据ID查询
    @Select("select id,mname,password,rights from lmanager where id=#{id}")
    Manager findById(Integer id);
    //新增
    @Insert("insert into lmanager(id,mname,password,rights) values(#{id},#{mname},#{password},#{rights})")
    @SelectKey(statement = "select seq_lmanager.nextval from dual",
            keyProperty = "id", resultType = int.class, before = true)
    int add(Manager manager);
    //修改
    @Update("update lmanager set mname=#{mname},password=#{password},rights=#{rights} where id=#{id}")
    int modify(Manager manager);
    //删除
    @Delete("delete lmanager where id = #{id}")
    int remove(Integer id);
    //通过用户名密码获得管理员对象
    Manager checkPwd(@Param("mname") String mname,@Param("password") String password);
    //验证用户名唯一
    @Select("select id,mname,password,rights from lmanager where mname=#{mname}")
    Manager checkMname(String mname);
}
