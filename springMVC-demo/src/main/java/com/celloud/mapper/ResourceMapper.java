package com.celloud.mapper;

import java.util.List;

import com.celloud.model.Resource;

public interface ResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);

    List<Resource> findPermissionResourcesByUserId(long userId);

    List<Resource> findAllResources();
}