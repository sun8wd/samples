package com.celloud.service.impl;

import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.celloud.dao.BusinessExceptionDao;
import com.celloud.service.BusinessExceptionService;

@Service("businessExceptionService")
public class BusinessExceptionServiceImpl implements BusinessExceptionService {
    @Resource
    private BusinessExceptionDao dao;

    @Override
    public void exception() {
        Random random = new Random();
        if (random.nextBoolean()) {
            throw new NullPointerException("我是service的空指针。。。");
        }
        dao.exception();
    }

}
