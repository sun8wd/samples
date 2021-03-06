package com.celloud.mapper;

import org.apache.ibatis.annotations.Param;

import com.celloud.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User login(@Param("username") String username, @Param("password") String password);

    User findByUsernameOrEmail(@Param("username") String username);
}