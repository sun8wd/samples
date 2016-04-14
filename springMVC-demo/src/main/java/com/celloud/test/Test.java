package com.celloud.test;

import org.apache.commons.collections.map.MultiKeyMap;
import org.apache.commons.collections.map.MultiValueMap;

public class Test {
    public static void main(String[] args) {
        testMultiKeyMap();
//        testMultiValueMap();
    }

    public static void testMultiKeyMap() {
        MultiKeyMap map = new MultiKeyMap();
        map.put(1, 2, "a");
        map.put(1, 3, "b");
        map.put(2, 3, "c");
        map.put(3, 2, "d");
        System.out.println("【MultiKeyMap】keys=" + map.keySet());
        System.out.println("【MultiKeyMap】vals=" + map.values());
        System.out.println("【MultiKeyMap】key=1      value=" + map.get(1));
        System.out.println("【MultiKeyMap】key=2      value=" + map.get(2));
        System.out.println("【MultiKeyMap】key=3      value=" + map.get(3));
        System.out.println("【MultiKeyMap】key=1,2    value=" + map.get(1, 2));
        System.out.println("【MultiKeyMap】key=1,3    value=" + map.get(1, 3));
        System.out.println("【MultiKeyMap】key=2,3    value=" + map.get(2, 3));
        System.out.println("【MultiKeyMap】key=3,2    value=" + map.get(3, 2));
    }

    public static void testMultiValueMap() {
        MultiValueMap map = new MultiValueMap();
        map.put("a", 1);
        map.put("a", 2);
        map.put("b", 3);
        System.out.println("【MultiValueMap】values=" + map.values());
        System.out.println("【MultiValueMap】key=a      value.class=" + map.get("a").getClass().getName());
        System.out.println("【MultiValueMap】key=a      value=" + map.get("a"));
        System.out.println("【MultiValueMap】key=b      value.class=" + map.get("b").getClass().getName());
        System.out.println("【MultiValueMap】key=b      value=" + map.get("b"));
        
    }
}
