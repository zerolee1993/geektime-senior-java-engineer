package com.zero.snippet.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串 OOM 案例
 * JDK1.8 Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 *
 * @author lishaofei
 * @date 2022/9/12 23:32
 */
public class StringOOMError {

    static String base = "string";

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String str = base + base;
            base = str;
            list.add(str.intern());
        }
        System.out.println(list);
    }

}
