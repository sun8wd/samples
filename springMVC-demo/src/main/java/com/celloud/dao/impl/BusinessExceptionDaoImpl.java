package com.celloud.dao.impl;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.celloud.dao.BusinessExceptionDao;
import com.celloud.utils.ExceptionUtil;

@Service("businessExceptionDao")
public class BusinessExceptionDaoImpl implements BusinessExceptionDao {

    @Override
    public void exception() {
        Random random = new Random();
        if (random.nextBoolean()) {
            throw new NullPointerException("我是Dao层的空指针。。。");
        }
        ExceptionUtil.exception();
    }

}
