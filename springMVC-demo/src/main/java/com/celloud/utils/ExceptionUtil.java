package com.celloud.utils;

import java.util.Random;

public class ExceptionUtil {
    public static void exception() {
        Random random = new Random();
        if (random.nextBoolean()) {
            throw new NullPointerException("我是util类的空指针。。。");
        }
    }
}
