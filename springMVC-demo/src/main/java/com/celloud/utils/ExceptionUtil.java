package com.celloud.utils;

import java.util.Random;

public class ExceptionUtil {
	public static void exception(){
		if(new Random().nextBoolean()){
			throw new NullPointerException("我是util类的空指针。。。");
		}
	}
}
