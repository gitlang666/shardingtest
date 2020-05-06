package com.lsx.shardingtest.dao;

import com.lsx.shardingtest.entity.Maxflag;
import com.lsx.shardingtest.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Dao {
    @Select("select * from user")
    public List<User> list();

    @Insert("insert into user(username,password,`count`) values(#{username},#{password},#{count})")
    public Integer add(User user);
    public Integer addBatch(@Param("list") List<User> list);


    @Select("select max(id) from user")
    int maxid();

    int maxflag(@Param("maxflag") Maxflag maxflag);

    List<User> getUserByPage(@Param("page")int page,@Param("num")int num);
}
